package com.btoy.wikimedia.consumer.consumer;

import com.btoy.wikimedia.consumer.dto.WikimediaStreamDataDto;
import com.btoy.wikimedia.consumer.model.WikimediaStreamData;
import com.btoy.wikimedia.consumer.repository.WikimediaStreamDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.btoy.wikimedia.consumer.util.Statics.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class WikimediaConsumerService {

    private final WikimediaStreamDataRepository wikimediaStreamRepository;
    private final ModelMapper mapper;
    // not listen now
    @Transactional
//    @KafkaListener(
//            topics = TOPIC_NAME_WIKIMEDIA,
//            groupId = GROUP_ID_WIKIMEDIA
//    )
    public void consumeWikimediaStream(WikimediaStreamDataDto wikimediaStreamDataDto, Acknowledgment ack){
        log.info("Consumed data: {}", wikimediaStreamDataDto.toString());
        WikimediaStreamData data = mapper.map(wikimediaStreamDataDto, WikimediaStreamData.class);
        wikimediaStreamRepository.save(data);
        ack.acknowledge();
    }
}
