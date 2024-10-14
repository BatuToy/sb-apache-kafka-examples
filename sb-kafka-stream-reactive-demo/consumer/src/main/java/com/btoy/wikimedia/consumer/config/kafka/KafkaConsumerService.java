package com.btoy.wikimedia.consumer.config.kafka;

import com.btoy.wikimedia.consumer.config.errorHandling.SendToDeadLetterQueueExceptionHandler;
import com.btoy.wikimedia.consumer.config.errorHandling.SourceNotFoundException;
import com.btoy.wikimedia.consumer.config.mapper.Mapper;
import com.btoy.wikimedia.consumer.model.DLTErrorMessage;
import com.btoy.wikimedia.consumer.model.KafkaUser;
import com.btoy.wikimedia.consumer.repository.DLTErrorMessageRepository;
import com.btoy.wikimedia.consumer.repository.KafkaUserRepository;
import com.btoy.wikimedia.shared.lib.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.btoy.wikimedia.consumer.util.Statics.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    // ConsumerService does not need a controller or anything else. This consumer service only serves for take the message and do
    // whatever you want with the message via persist to db

    private final KafkaUserRepository kafkaUserRepository;
    private final DLTErrorMessageRepository dltErrorMessageRepository;
    private final Mapper mapper;
    @RetryableTopic(
            include = SourceNotFoundException.class,
            attempts = "5",
            backoff = @Backoff(delay = 2000, multiplier = 2)
    )
    @KafkaListener(
            topics = TOPIC_NAME_KAFKA_USER,
            groupId = GROUP_ID_KAFKA_USER,
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeKafkaUserDtoMessageFromKafkaServer(KafkaUserDto kafkaUserDto, Acknowledgment ack){
        // In default kafka-consumers can pull all the data types include Null messages. I don't want to take null messages in my database.
        if(kafkaUserDto.getEmail() == null){
            // Actually message already consumed but if we don't return our ack consumer-instance doesn't understand that the message was consumed.
            log.error("Message not consumed!");
            throw new SourceNotFoundException("Data can not be null!");
            // ToDo: We need to send this null messages to DeadLetterTopic's.
        }
        KafkaUser kafkaUser =  mapper.mapToEntity(kafkaUserDto);
        kafkaUserRepository.save(kafkaUser);
        log.info("CONSUMED MESSAGE: {}", kafkaUserDto); // Consuming message is dto message not the model itself!
        ack.acknowledge();
    }

    @DltHandler
    public void handleDltQueueMessages(KafkaUserDto kafkaUserDto, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        DLTErrorMessage dltErrorMessage = mapper.toDltErrorMessage(kafkaUserDto);
        dltErrorMessage.setCreationTime(LocalDateTime.now());
        dltErrorMessage.setMessage("Message has been not consumed! The data:" +
                "\n" + kafkaUserDto.toString());
        dltErrorMessage.setIsConsumed(false);
        dltErrorMessageRepository.save(dltErrorMessage);
        log.info("Data has been sent to dead letter topic and saved to the database! The message topic: {} \n The data: {}",
                    topic, kafkaUserDto.toString()
                );
    }

}

