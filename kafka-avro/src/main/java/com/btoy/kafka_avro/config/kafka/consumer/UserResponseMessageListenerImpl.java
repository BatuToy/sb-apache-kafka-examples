package com.btoy.kafka_avro.config.kafka.consumer;

import com.btoy.kafka_avro.dto.avro.User;
import com.btoy.kafka_avro.ports.input.message.UserResponseMessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserResponseMessageListenerImpl implements UserResponseMessageListener {

    // ToDo: Implement here for SpecificRecord's on Kafka Avro Schemas


    @Override
    @KafkaListener(topics = "${kafka-producer-config.topic-name}",
            groupId = "${kafka-consumer-config.group-id}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consume(User consumedEvent, Acknowledgment ack) {
        log.info("Event consumed: {}", consumedEvent);
        ack.acknowledge();
    }
}
