package com.btoy.kafka_avro.ports.input.message;

import com.btoy.kafka_avro.config.kafka.common.event.EventConsumer;
import com.btoy.kafka_avro.dto.avro.User;
import org.springframework.kafka.support.Acknowledgment;

public interface UserResponseMessageListener extends EventConsumer<User> {
    @Override
    void consume(User consumedEvent, Acknowledgment ack);
}
