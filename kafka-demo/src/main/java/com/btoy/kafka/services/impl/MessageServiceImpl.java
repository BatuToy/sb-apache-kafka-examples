package com.btoy.kafka.services.impl;

import com.btoy.kafka.payload.KafkaUser;
import com.btoy.kafka.producer.KafkaProducer;
import com.btoy.kafka.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final KafkaProducer kafkaProducer;

    @Override
    public void sendStringPayload(String msg) {
        kafkaProducer.sendStringMessage(msg);
    }

    @Override
    public KafkaUser sendJsonPayload(KafkaUser kafkaUser) {
        kafkaProducer.sendJsonMessage(kafkaUser);
        // Todo: "KafkaUser" return type is not must but done with best practice
        return kafkaUser;
    }
}
