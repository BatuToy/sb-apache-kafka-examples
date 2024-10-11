package com.btoy.wikimedia.producer.produce;

import com.btoy.wikimedia.producer.payload.WikimediaStreamData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static com.btoy.wikimedia.producer.util.Statics.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaProducerService {

    // specified WikimediaStreamData!
    private final KafkaTemplate<String, WikimediaStreamData> kafkaTemplate;

    public void publishMessage(WikimediaStreamData wikimediaStreamData){
        Message<WikimediaStreamData> message = MessageBuilder
                .withPayload(wikimediaStreamData)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME_WIKIMEDIA)
                .build();
        kafkaTemplate.send(message);
    }

}
