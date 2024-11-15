package com.btoy.kafka_avro.config.kafka.common.event;

import org.apache.avro.specific.SpecificRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface EventConsumer<T> {
    void consume(T consumedEvent, Acknowledgment ack);
}
