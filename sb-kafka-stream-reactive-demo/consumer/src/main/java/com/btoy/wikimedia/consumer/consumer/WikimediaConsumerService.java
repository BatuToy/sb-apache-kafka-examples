package com.btoy.wikimedia.consumer.consumer;

import com.btoy.wikimedia.consumer.config.errorHandling.SourceNotFoundException;
import com.btoy.wikimedia.consumer.config.mapper.Mapper;
import com.btoy.wikimedia.consumer.dto.WikimediaStreamDataDto;
import com.btoy.wikimedia.consumer.model.DLTErrorMessage;
import com.btoy.wikimedia.consumer.model.WikimediaStreamData;
import com.btoy.wikimedia.consumer.repository.DLTErrorMessageRepository;
import com.btoy.wikimedia.consumer.repository.WikimediaStreamDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.btoy.wikimedia.consumer.util.Statics.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class WikimediaConsumerService {

    private final WikimediaStreamDataRepository wikimediaStreamRepository;
    private final DLTErrorMessageRepository dltErrorMessageRepository;
    private final Mapper mapper;

//    @RetryableTopic(
//            include = SourceNotFoundException.class, attempts = "5",
//            backoff = @Backoff( delay = 2000, multiplier = 2)
//    )
//    @KafkaListener(
//            topics = TOPIC_NAME_WIKIMEDIA, groupId = GROUP_ID_WIKIMEDIA
//    )
    @Transactional
    public void consumeWikimediaStream(WikimediaStreamDataDto wikimediaStreamDataDto, Acknowledgment ack){
        WikimediaStreamData wikimediaStreamData = mapper.mapToWikimediaStreamDataDto(wikimediaStreamDataDto);
        wikimediaStreamRepository.save(wikimediaStreamData);
        ack.acknowledge();
        log.info("CONSUMED DATA: {}", wikimediaStreamDataDto.toString());
    }

    @DltHandler
    public void wikimediaStreamDLTHandler(WikimediaStreamDataDto wikimediaStreamDataDto,
                                          @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                          @Header(KafkaHeaders.GROUP_ID) String groupId){
        DLTErrorMessage dltErrorMessage = mapper.mapToDltErrorMessages(wikimediaStreamDataDto);
        dltErrorMessage.setIsConsumed(false);
        dltErrorMessage.setCreationTime(LocalDateTime.now());
        dltErrorMessage.setMessage("Message has been not consumed! The data:" +
                "\n" + wikimediaStreamDataDto.toString());
        dltErrorMessageRepository.save(dltErrorMessage);
        log.info("Message has not been consumed from kafka-consumer! Message has been persist to t_dlt_messages! \n" +
                "MESSAGE: {}, \t TOPIC: {} \t GROUP_ID: {}",
                wikimediaStreamDataDto.toString(),
                topic,
                groupId);
    }

}
