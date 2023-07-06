package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.acme.config.ThreadPoolManager;
import org.acme.dto.EbpInsuredDTO;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

@ApplicationScoped
public class EbpValidationInsuredService {

    @Inject
    private ThreadPoolManager threadPoolManager;

    public CompletableFuture<List<Map<String, Object>>> validationInsured(List<EbpInsuredDTO> ebpInsuredDTOS){
        ExecutorService threadPool = threadPoolManager.getThreadPool();
        List<Map<String, Object>> results = new ArrayList<>();
        return CompletableFuture.supplyAsync(() -> {

            int batchSize = 100;

            IntStream.range(0, (ebpInsuredDTOS.size() + batchSize - 1) / batchSize)
                    .mapToObj(i -> ebpInsuredDTOS.subList(i * batchSize, Math.min(ebpInsuredDTOS.size(), (i + 1) * batchSize))) // Extract the batch from the list
                    .forEach(batch -> batch.parallelStream().forEach(ebpInsuredDTO -> {

                        Map<String, Object> result = new HashMap<>();
                        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
                        Validator validator = validatorFactory.getValidator();
                        Set<ConstraintViolation<EbpInsuredDTO>> violations =
                                validator.validate(ebpInsuredDTO);
                        result.put("personalCif", ebpInsuredDTO.getPersonCif());
                        if (violations.isEmpty()) {
                            System.out.println("Validation insured passed");
                            result.put("valid", Boolean.TRUE);
                        }else{
                            for (ConstraintViolation<EbpInsuredDTO> violation : violations) {
                                result.put(violation.getPropertyPath().toString(),
                                        violation.getMessage());
                            }
                            result.put("valid", Boolean.FALSE);
                        }
                        results.add(result);
                    }));

            return results;
        }, threadPool);
    }

}
