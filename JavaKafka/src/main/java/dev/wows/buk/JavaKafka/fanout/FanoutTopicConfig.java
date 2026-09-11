package dev.wows.buk.JavaKafka.fanout;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class FanoutTopicConfig {

    @Bean 
    public NewTopic fanouTopic() {
        return TopicBuilder.name("order-events-fanout")
                .partitions(1)
                .replicas(1)
                .build();
    }
}

 
