package dev.wows.buk.JavaKafka.plain;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service 
public class PlainProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PlainProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String event) {
        kafkaTemplate.send("order-events-plain", event);
    }
}
