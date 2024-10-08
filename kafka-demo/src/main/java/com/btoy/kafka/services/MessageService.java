package com.btoy.kafka.services;

import com.btoy.kafka.payload.KafkaUser;

public interface MessageService {
    void sendStringPayload(String msg);
    KafkaUser sendJsonPayload(KafkaUser kafkaUser);
}
