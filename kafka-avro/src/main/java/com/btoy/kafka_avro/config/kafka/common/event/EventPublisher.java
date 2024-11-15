package com.btoy.kafka_avro.config.kafka.common.event;

import org.apache.avro.specific.SpecificRecord;

public interface EventPublisher<T extends SpecificRecord> {
    void send(T event);
}
