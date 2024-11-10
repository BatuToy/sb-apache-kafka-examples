package com.btoy.kafka_avro.ports.output.message;

import com.btoy.kafka_avro.config.kafka.common.event.EventPublisher;
import com.btoy.kafka_avro.dto.avro.User;

public interface KafkaPublishUserMessage extends EventPublisher<User> {
    @Override
    void send(User event);
}
