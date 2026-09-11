package dev.wows.buk.JavaKafka.parallel;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component 
public class ParallelConsumer {
    @KafkaListener(topics = "order-events-parallel", groupId = "order-processing-group")
    public void listenerOne(ConsumerRecord<String, String> record) {
        System.out.println("PROCESSOR-1 partition="
                                + record.partition()
                                + " value="
                                + record.value()  
        );
    }

    @KafkaListener(topics = "order-events-parallel", groupId = "order-processing-group")
    public void listenerTwo(ConsumerRecord<String, String> record) {
        System.out.println("PROCESSOR-2 partition="
                                + record.partition()
                                + " value="
                                + record.value()  
        );
    }
}
