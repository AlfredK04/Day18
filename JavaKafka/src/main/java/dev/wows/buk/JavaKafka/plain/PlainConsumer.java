package dev.wows.buk.JavaKafka.plain;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component 
public class PlainConsumer {
    @KafkaListener(topics = "order-events-plain")
    public void receive(String event) {
        System.out.println("AUDIT <- " + event);
    }
}
