package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.config.ThreadPoolManager;
import org.acme.exception.BusinessException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@ApplicationScoped
public class ValidationObjectService {
    @Inject
    private ThreadPoolManager threadPoolManager;

    private static final String SUCCESS = "success";
    public CompletableFuture<String> validateObject(String input){
        ExecutorService threadPool = threadPoolManager.getThreadPool();
        return CompletableFuture.supplyAsync(() -> {
            if(!input.equalsIgnoreCase("dicky")){
                throw new BusinessException("Error Naming Cannot Dicky");
            }
            System.out.println("input 1" + input);
            return SUCCESS;
        }, threadPool);

    }

    public CompletableFuture<String> validateObject2(String input){
        ExecutorService threadPool = threadPoolManager.getThreadPool();
        return CompletableFuture.supplyAsync(() -> {
            if(!input.equalsIgnoreCase("dicky")){
                throw new BusinessException("Error Naming Cannot Dicky");
            }
            System.out.println("input 2" + input);
            return SUCCESS;
        }, threadPool);
    }

}
