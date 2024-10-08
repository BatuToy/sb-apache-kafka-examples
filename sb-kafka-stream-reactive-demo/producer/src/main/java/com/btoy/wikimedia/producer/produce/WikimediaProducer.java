package com.btoy.wikimedia.producer.produce;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.btoy.wikimedia.producer.util.Statics.TOPIC_NAME;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String msg){
        kafkaTemplate.send(TOPIC_NAME, msg);
    }
}
