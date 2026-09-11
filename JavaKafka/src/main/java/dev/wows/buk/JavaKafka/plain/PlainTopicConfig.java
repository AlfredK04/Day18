package dev.wows.buk.JavaKafka.plain;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration 
public class PlainTopicConfig {
    @Bean 
    public NewTopic plainTopic() {
        return TopicBuilder.name("order-events-plain")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
