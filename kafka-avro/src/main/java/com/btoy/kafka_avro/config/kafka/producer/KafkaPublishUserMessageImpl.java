package com.btoy.kafka_avro.config.kafka.producer;

import com.btoy.kafka_avro.dto.avro.User;
import com.btoy.kafka_avro.ports.output.message.KafkaPublishUserMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaPublishUserMessageImpl implements KafkaPublishUserMessage {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void send(User event) {
        final String key = UUID.randomUUID().toString();
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(new ProducerRecord<>(key, event));
        future.whenCompleteAsync((result, exception) ->{
            RecordMetadata recordMetadata = result.getRecordMetadata();
            if(exception == null){
                log.info("Event with the Topic Name: {} \n Message Offset: {} \n Published Time: {} published SUCCESSFULLY!",
                        recordMetadata.topic(), recordMetadata.offset(), recordMetadata.timestamp());
            } else {
                log.warn("Event with the Topic Name: {} \n Message Offset: {} \n Published Time: {} cannot published. \n Error: {}",
                        recordMetadata.topic(), recordMetadata.offset(), recordMetadata.timestamp(), exception.getLocalizedMessage());
            }
        });
    }
}
