package com.btoy.wikimedia.consumer.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.btoy.wikimedia.consumer.util.Statics.GROUP_ID;
import static com.btoy.wikimedia.consumer.util.Statics.TOPIC_NAME;

@Slf4j
@Service
@RequiredArgsConstructor
public class WikimediaConsumer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    // postgres integration to store the coming data from "consumeWikimediaStream"

    @KafkaListener(
            topics = TOPIC_NAME,
            groupId = GROUP_ID
    )
    public void consumeWikimediaStream(String msg){
        log.info("Consumed data: {}", msg);
    }
}
