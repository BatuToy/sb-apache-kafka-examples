package com.btoy.kafka_avro.ports.output.message;

import com.btoy.kafka_avro.config.kafka.common.event.EventPublisher;
import com.btoy.kafka_avro.domain.event.EmployeeEvent;
import com.btoy.kafka_avro.dto.avro.EmployeeAvro;

public interface KafkaPublishEmployeeMessage extends EventPublisher<EmployeeEvent> {
    @Override
    void send(EmployeeEvent event);
}
