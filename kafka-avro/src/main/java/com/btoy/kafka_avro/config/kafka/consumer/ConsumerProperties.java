package com.btoy.kafka_avro.config.kafka.consumer;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
@Getter
@Setter
public class ConsumerProperties {
    private String groupId;
    private String keyDeserializer;
    private String valueDeserializer;
    private String sessionTimeOutMs;
}
