//package org.acme;
//
//import io.smallrye.reactive.messaging.kafka.KafkaConsumer;
//import org.eclipse.microprofile.health.HealthCheck;
//import org.eclipse.microprofile.health.HealthCheckResponse;
//
//public class KafkaHealthCheck implements HealthCheck {
//    @Override
//    public HealthCheckResponse call() {
//        try {
//            return HealthCheckResponse.up("Kafka is running.");
//        } catch (Exception e) {
//            return HealthCheckResponse.down("Kafka is not running or encountered an error: " + e.getMessage());
//        }
//    }
//}
