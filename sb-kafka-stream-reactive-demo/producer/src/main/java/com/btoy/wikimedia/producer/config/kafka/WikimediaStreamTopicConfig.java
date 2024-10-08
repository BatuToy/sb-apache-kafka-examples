package com.btoy.wikimedia.producer.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.btoy.wikimedia.producer.util.Statics.ONE;
import static com.btoy.wikimedia.producer.util.Statics.TOPIC_NAME;

@Configuration
public class WikimediaStreamTopicConfig {

    @Bean
    public NewTopic wikimediaStreamTopic(){
        return TopicBuilder
                .name(TOPIC_NAME)
                .partitions(ONE).
                replicas(ONE)
                .build();
    }
}
