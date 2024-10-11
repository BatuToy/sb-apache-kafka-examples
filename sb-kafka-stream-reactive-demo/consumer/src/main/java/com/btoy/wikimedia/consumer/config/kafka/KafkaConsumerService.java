package com.btoy.wikimedia.consumer.config.kafka;

import com.btoy.wikimedia.consumer.config.mapper.Mapper;
import com.btoy.wikimedia.consumer.model.KafkaUser;
import com.btoy.wikimedia.consumer.repository.KafkaUserRepository;
import com.btoy.wikimedia.shared.lib.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import static com.btoy.wikimedia.consumer.util.Statics.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    // ConsumerService does not need a controller or anything else. This consumer service only serves for take the message and do
    // whatever you want with the message via persist to db

    private final KafkaUserRepository kafkaUserRepository;
    private final Mapper mapper;
//    @RetryableTopic(
//            attempts = "5",
//            backoff = @Backoff(delay = 2000, multiplier = 2)
//    )
    @KafkaListener(
            topics = TOPIC_NAME_KAFKA_USER,
            groupId = GROUP_ID_KAFKA_USER,
            containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeKafkaUserDtoMessageFromKafkaServer(KafkaUserDto kafkaUserDto, Acknowledgment ack){
        // In default kafka-consumers can pull all the data types include Null Messages but i don't want to take null messages in my database.
        if(kafkaUserDto == null){
            // Actually message already consumed but if we don't return our ack consumer-instance doesnt understand that the message was consumed.
            log.error("Message not consumed!");
            throw new RuntimeException("Data can not be null!");
        }
        KafkaUser kafkaUser =  mapper.mapToEntity(kafkaUserDto);
        kafkaUserRepository.save(kafkaUser);
        log.info("CONSUMED MESSAGE: {}", kafkaUserDto); // Consuming message is dto message not the model itself!
        ack.acknowledge();
    }

    // TODO: DltErrorMessage Handler comes soon!

}

