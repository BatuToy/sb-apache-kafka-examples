package com.btoy.kafka_avro.config.kafka.common.event;

import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.support.Acknowledgment;

public interface EventConsumer<T extends SpecificRecordBase> {
    void consume(T consumedEvent, Acknowledgment ack);
}
