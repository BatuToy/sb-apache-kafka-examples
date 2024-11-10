package com.btoy.kafka_avro.config.kafka.producer;

import com.btoy.kafka_avro.config.kafka.KafkaProperties;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class ProducerFactory {

    private final ProducerProperties producerProperties;
    private final KafkaProperties kafkaProperties;

    @Bean
    public org.springframework.kafka.core.ProducerFactory<String, Object> producerFactory(){
        HashMap<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, producerProperties.getKeySerializer());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, producerProperties.getValueSerializer());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServer());
        properties.put(ProducerConfig.ACKS_CONFIG, producerProperties.getAcks());
        return new DefaultKafkaProducerFactory<>(properties);
    }

    @Bean
    public KafkaTemplate<String, Object> tyKafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
