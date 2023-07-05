package org.acme.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.dto.EbpRootDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

@ApplicationScoped
public class EbpValidatorService {

    public Boolean validate() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path jsonFilePath = Path.of(getClass().getClassLoader().getResource("JSON-EBP.json").toURI());
        String jsonContent = Files.readString(jsonFilePath);
        EbpRootDTO myObject = objectMapper.readValue(jsonContent, EbpRootDTO.class);

        String json = objectMapper.writeValueAsString(myObject);
        System.out.println(json);
        return true;
    }

}
