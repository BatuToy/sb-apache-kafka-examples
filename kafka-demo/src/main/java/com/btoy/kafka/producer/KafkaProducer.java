package com.btoy.kafka.producer;

import com.btoy.kafka.config.KafkaUserTopic;
import com.btoy.kafka.payload.KafkaUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplateString;
    private final KafkaTemplate<String, KafkaUser> kafkaTemplateJson;
    private static final String TOPIC_NAME = new KafkaUserTopic().kafkaUserCreateTopic().name();
    // Sending message to kafka-server from producer.

    public void sendStringMessage(String msg){
        getInfo(msg);
        kafkaTemplateString.send(TOPIC_NAME, msg);
    }

    public void sendJsonMessage(KafkaUser kafkaUser) {
        Message<KafkaUser> kafkaUserMessage = MessageBuilder
                .withPayload(kafkaUser)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_NAME)
                .build();
        kafkaTemplateJson.send(kafkaUserMessage);
        getInfo(kafkaUser.toString());
    }

    private static void getInfo(Object msg) {
        log.info("Sending message to {} \n Message: {}", TOPIC_NAME, msg);
    }
}
