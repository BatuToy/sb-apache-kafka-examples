package com.btoy.kafka_avro.config.kafka.common.event;

public interface EventPublisher<T> {
    void send(T event);
}
