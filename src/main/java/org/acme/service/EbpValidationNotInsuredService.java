package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.acme.config.ThreadPoolManager;
import org.acme.dto.EbpOrganizationDTO;
import org.acme.dto.EbpProgramDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@ApplicationScoped
public class EbpValidationNotInsuredService {
    @Inject
    private ThreadPoolManager threadPoolManager;
    public CompletableFuture<Map<String, Object>> validationNotInsuredOrganization(EbpOrganizationDTO ebpOrganizationDTO){
        ExecutorService threadPool = threadPoolManager.getThreadPool();
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<EbpOrganizationDTO>> violations =
                    validator.validate(ebpOrganizationDTO);

            if (violations.isEmpty()) {
                System.out.println("Validation organization passed");
                result.put("valid", Boolean.TRUE);
            }else{
                for (ConstraintViolation<EbpOrganizationDTO> violation : violations) {
                        result.put(violation.getPropertyPath().toString(),
                                violation.getMessage());
                }
                result.put("valid", Boolean.FALSE);
            }
            return result;
        }, threadPool);
    }

    public CompletableFuture<Map<String, Object>> validationNotInsuredProgram(EbpProgramDTO ebpProgramDTO){
        ExecutorService threadPool = threadPoolManager.getThreadPool();
        return CompletableFuture.supplyAsync(() -> {
            Map<String, Object> result = new HashMap<>();
            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();
            Set<ConstraintViolation<EbpProgramDTO>> violations =
                    validator.validate(ebpProgramDTO);

            if (violations.isEmpty()) {
                System.out.println("Validation program passed");
                result.put("valid", Boolean.TRUE);
            }else{
                for (ConstraintViolation<EbpProgramDTO> violation : violations) {
                    result.put(violation.getPropertyPath().toString(),
                            violation.getMessage());
                }
                result.put("valid", Boolean.FALSE);
            }
            return result;
        }, threadPool);
    }

}
