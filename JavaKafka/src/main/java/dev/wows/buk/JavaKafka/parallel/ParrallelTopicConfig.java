package dev.wows.buk.JavaKafka.parallel;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ParrallelTopicConfig {
    @Bean 
    public NewTopic parallelTopic() {
        return TopicBuilder.name("order-events-parallel")
                .partitions(2)
                .replicas(1)
                .build();
    }
}

 
