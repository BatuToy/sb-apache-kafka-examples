package com.btoy.kafka_avro.config.kafka.producer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka-producer-config")
@Getter
@Setter
public class ProducerProperties {
    private String keySerializer;
    private String valueSerializer;
    private String topicName;
    private int acks;
}
