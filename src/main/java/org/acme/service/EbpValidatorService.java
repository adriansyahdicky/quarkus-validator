package org.acme.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.EbpRootDTO;
import org.acme.dto.ResultDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class EbpValidatorService {

    @Inject
    EbpValidationNotInsuredService ebpValidationNotInsuredService;

    @Inject
    EbpValidationInsuredService ebpValidationInsuredService;

    public ResultDTO validate() throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path jsonFilePath = Path.of(getClass().getClassLoader().getResource("JSON-EBP.json").toURI());
        String jsonContent = Files.readString(jsonFilePath);
        EbpRootDTO myObject = objectMapper.readValue(jsonContent, EbpRootDTO.class);

        CompletableFuture<Map<String, Object>> resultOrganization =
                ebpValidationNotInsuredService.validationNotInsuredOrganization(myObject.getOrganization());

        CompletableFuture<Map<String, Object>> resultProgram =
                ebpValidationNotInsuredService.validationNotInsuredProgram(myObject.getProgram());

        CompletableFuture<List<Map<String, Object>>> resultInsured =
                ebpValidationInsuredService.validationInsured(myObject.getInsured());

        CompletableFuture.allOf(resultOrganization, resultProgram, resultInsured).join();

        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setOrganization(resultOrganization.get());
        resultDTO.setProgram(resultProgram.get());
        resultDTO.setInsured(resultInsured.get());

        return resultDTO;
    }


}
