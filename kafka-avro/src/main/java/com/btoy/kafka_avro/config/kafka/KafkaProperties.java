package com.btoy.kafka_avro.config.kafka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka-config")
@Getter
@Setter
public class KafkaProperties {
    private String bootstrapServer;
    private String topicName;
    private Short replicationFactor;
    private Integer numOfPartitions;
}
