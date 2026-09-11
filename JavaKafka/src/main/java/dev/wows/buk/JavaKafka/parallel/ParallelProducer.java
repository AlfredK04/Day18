package dev.wows.buk.JavaKafka.parallel;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service 
public class ParallelProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public ParallelProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String event) {
        String key = event.split(":")[0];
        var future = kafkaTemplate.send(
            "order-events-parallel",
            key,
            event
        );

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println(
                    "ACK received: topic="
                        + result.getRecordMetadata().topic()
                        + ", partition="
                        + result.getRecordMetadata().partition()
                        + ", offset="
                        + result.getRecordMetadata().offset()
                );
            } else {
                System.out.println("Send failed: " + ex.getMessage());
            }
        });
    }
}