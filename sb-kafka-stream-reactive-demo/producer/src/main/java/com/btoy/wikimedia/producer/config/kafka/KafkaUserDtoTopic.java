package com.btoy.wikimedia.producer.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.btoy.wikimedia.producer.util.Statics.*;

@Configuration
public class KafkaUserDtoTopic {

    @Bean
    public NewTopic userDtoTopic(){
        return TopicBuilder
                .name(TOPIC_NAME_KAFKA_USER)
                .replicas(ONE)
                .partitions(ONE)
                .build();
    }
}
