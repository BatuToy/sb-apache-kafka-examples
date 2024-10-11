package com.btoy.wikimedia.producer.config.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaPublishMessageService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    // This sends message method is only for String values that will be delivered to Kafka-Server.
    public void sendMessage(String topic, String message, int partition){
        ProducerRecord<String, Object> record = new ProducerRecord<>(topic, message, partition);
        kafkaTemplate.send(record);
    }
    // We can send object with using Message interface. Also "GenericMessage.class" implements that interface too. With support payload and headers.
    public void sendMessage(GenericMessage message){
        // we keep the producerRecord object in SendResult class. As you can see we can get the metadata of the payload and the producerRecord from the CompletableFuture's SendResult class.
        CompletableFuture<SendResult<String, Object>> completableFuture =  kafkaTemplate.send(message);
        // You can use this method sync too. Check the CompletableFuture's class.
        completableFuture.whenCompleteAsync((result, exception) -> {
            ProducerRecord<String, Object> record = result.getProducerRecord();
            RecordMetadata metadata = result.getRecordMetadata();
            if(exception == null){
                log.info("MESSAGE: {} \n TOPIC: {} \t PARTITION: {} \t OFFSET: {}, TIMESTAMP: {}",
                        message,
                        metadata.topic(),
                        metadata.partition(),
                        metadata.offset(),
                        metadata.timestamp()
                );
            } else {
                log.error("Can not send message to TOPIC: {} CAUSE OF = {}",
                        record.topic(),
                        exception.getLocalizedMessage()
                );
            }
        });
    }
}
