package com.btoy.kafka_avro.ports.input.message;

import com.btoy.kafka_avro.config.kafka.common.event.EventConsumer;
import com.btoy.kafka_avro.dto.avro.EmployeeAvro;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;

public interface EmployeeResponseMessageListener extends EventConsumer<ConsumerRecord<String, EmployeeAvro>> {
    @Override
    void consume(ConsumerRecord<String, EmployeeAvro> consumedEvent, Acknowledgment ack);
}
