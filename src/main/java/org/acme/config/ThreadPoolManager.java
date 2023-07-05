package org.acme.config;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class ThreadPoolManager {
    private ExecutorService threadPool;

    public void onStart(@Observes StartupEvent event) {
        int poolSize = 10; // Specify the desired pool size
        threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public ExecutorService getThreadPool() {
        return threadPool;
    }

    public void onStop(@Observes ShutdownEvent event) {
        threadPool.shutdown();
    }
}
