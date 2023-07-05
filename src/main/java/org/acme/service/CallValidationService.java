package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
public class CallValidationService {

    @Inject
    ValidationObjectService validationObjectService;

    private static final String SUCCESS = "success";

    public Boolean validation() throws ExecutionException, InterruptedException {
        CompletableFuture<String> validateObject =
                validationObjectService.validateObject("joko").handle((result, throwable) -> {
            if (throwable != null) {
                System.err.println("Exception occurred: " + throwable.getMessage());
                return "Fallback value";
            } else {
                return result;
            }
        });

        CompletableFuture<String> validateObject2 =
                validationObjectService.validateObject2("dicky").handle((result, throwable) -> {
                    if (throwable != null) {
                        System.err.println("Exception occurred: " + throwable.getMessage());
                        return "Fallback value";
                    } else {
                        return result;
                    }});

        CompletableFuture.allOf(validateObject, validateObject2).join();
        return validateObject.get().equalsIgnoreCase(SUCCESS) && validateObject2.get().equalsIgnoreCase(SUCCESS);
    }

}
