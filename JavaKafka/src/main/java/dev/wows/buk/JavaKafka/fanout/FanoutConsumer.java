package dev.wows.buk.JavaKafka.fanout;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component 
public class FanoutConsumer {
    @KafkaListener(topics = "order-events-fanout", groupId = "customer-notification-group")
    public void notificationListner(String event) {
        System.out.println(
            "NOTIFICATION <- " + event
        );
    }

    @KafkaListener(topics = "order-events-fanout", groupId = "analytics-group")
    public void analyticsListener(String event) {
        System.out.println(
            "ANALYTICS <- " + event
        );
    }
}
