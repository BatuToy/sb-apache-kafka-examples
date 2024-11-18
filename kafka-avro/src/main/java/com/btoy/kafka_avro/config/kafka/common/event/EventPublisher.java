package com.btoy.kafka_avro.config.kafka.common.event;

import com.btoy.kafka_avro.common.event.DomainEvent;

public interface EventPublisher<T> {
    void send(T event);
}
