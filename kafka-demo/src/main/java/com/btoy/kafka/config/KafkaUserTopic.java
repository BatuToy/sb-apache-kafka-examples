package com.btoy.kafka.config;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Service;

@Configuration
public class KafkaUserTopic {
    private static final String TOPIC_NAME="btoy-topic";

    @Bean
    public NewTopic kafkaUserCreateTopic(){
        return TopicBuilder
                .name(TOPIC_NAME)
                .partitions(1) // Default: 1
                .replicas(1) // Default: 1
                .build();
    }
}
