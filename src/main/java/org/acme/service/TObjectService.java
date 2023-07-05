package org.acme.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.acme.dto.DataIncrestDTO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

@ApplicationScoped
public class TObjectService {


    public Boolean getAllObject() throws URISyntaxException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path jsonFilePath = Path.of(getClass().getClassLoader().getResource("data.json").toURI());
        String jsonContent = Files.readString(jsonFilePath);
        DataIncrestDTO myObject = objectMapper.readValue(jsonContent, DataIncrestDTO.class);

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DataIncrestDTO>> violations = validator.validate(myObject);

        if (violations.isEmpty()) {
            System.out.println("Validation passed");
            String json = objectMapper.writeValueAsString(myObject);
            System.out.println(json);
        } else {
            System.out.println("Validation failed. Violations:");
            for (ConstraintViolation<DataIncrestDTO> violation : violations) {

                String propertyPath = violation.getPropertyPath().toString();
                if(propertyPath.contains("[") || propertyPath.contains("]")) {
                    int index = extractIndex(propertyPath);
                    System.out.println(violation.getRootBean().getIncrest()
                            .get(index).getName() + ": " + violation.getMessage());
                }

                System.out.println("-------------------");
                System.out.println(violation.getMessage());
            }
            return Boolean.FALSE;
        }


        return Boolean.TRUE;
    }

    private int extractIndex(String propertyPath) {
        int startIndex = propertyPath.indexOf('[');
        int endIndex = propertyPath.indexOf(']');
        String indexStr = propertyPath.substring(startIndex + 1, endIndex);
        return Integer.parseInt(indexStr);
    }

}
