package com.btoy.kafka_avro.config.kafka.consumer;

import com.btoy.kafka_avro.config.kafka.KafkaProperties;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDe;
import io.confluent.kafka.serializers.AbstractKafkaSchemaSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ConsumerFactory {

    private final ConsumerProperties consumerProperties;
    private final KafkaProperties kafkaProperties;

    @Bean
    public org.springframework.kafka.core.ConsumerFactory<String, Object> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(
                consumerProperties(),
                new StringDeserializer(),
                new KafkaAvroDeserializer()
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }

    private Map<String, Object> consumerProperties(){
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServer());
        properties.put(AbstractKafkaSchemaSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, kafkaProperties.getSchemaRegistryUrl());
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerProperties.getGroupId());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, consumerProperties.getKeyDeserializer());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, consumerProperties.getValueDeserializer());
        properties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, kafkaProperties.getSpecificAvroReader());
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, consumerProperties.getSessionTimeOutMs());
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, consumerProperties.getSessionTimeOutMs());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }
}
