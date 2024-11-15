package com.btoy.kafka_avro.ports.output.message;

import com.btoy.kafka_avro.config.kafka.common.event.EventPublisher;
import com.btoy.kafka_avro.dto.avro.EmployeeAvro;

public interface KafkaPublishEmployeeMessage extends EventPublisher<EmployeeAvro> {
    @Override
    void send(EmployeeAvro event);
}
