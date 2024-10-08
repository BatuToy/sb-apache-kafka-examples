package com.btoy.kafka.consumer;

import com.btoy.kafka.payload.KafkaUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class KafkaConsumer {

    private static final String TOPIC_NAME="btoy-topic";
    private static final String GROUP_ID="ex-group";

    //@KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consumeStringMessage(String msg){
        if(msg.isEmpty()){
            throw new RuntimeException("Message cant consumed");
        }
        //log.info("Consuming message: {}", msg);
    }

    @KafkaListener(
            topics = TOPIC_NAME,
            groupId = GROUP_ID
    )
    public void consumeJsonMessage(KafkaUser kafkaUser){
        if(Objects.isNull(kafkaUser)){
            throw new RuntimeException("Message cant consumed");
        }
        log.info("Consuming message: {}", kafkaUser.toString());
    }
}
