package com.btoy.kafka_avro.config.kafka.consumer;

import com.btoy.kafka_avro.dto.avro.EmployeeAvro;
import com.btoy.kafka_avro.ports.input.message.EmployeeResponseMessageListener;
import com.btoy.kafka_avro.ports.input.service.KafkaAvroApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserResponseMessageListenerImpl implements EmployeeResponseMessageListener {

    private final KafkaAvroApplicationService kafkaAvroApplicationService;

    @Override
    @KafkaListener(topics = "${kafka-producer-config.topic-name}",
            groupId = "${kafka-consumer-config.group-id}",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void consume(ConsumerRecord<String, EmployeeAvro> avroConsumerRecord, Acknowledgment ack) {
        EmployeeAvro employeeAvro = avroConsumerRecord.value();
        log.info("Event consumed offset: {}", avroConsumerRecord.offset());
        log.info("Event consumed with key: {}", avroConsumerRecord.key());
        log.info("Event consumed with avro value: {}", employeeAvro);
        // map to domain object!
        // persist to db! -? Go To send() again WTF!
        ack.acknowledge();
    }
}
