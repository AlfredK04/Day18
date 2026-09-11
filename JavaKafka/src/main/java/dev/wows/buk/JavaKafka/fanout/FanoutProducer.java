package dev.wows.buk.JavaKafka.fanout;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service 
public class FanoutProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public FanoutProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String event) {
        kafkaTemplate.send("order-events-fanout", event);
    }
}