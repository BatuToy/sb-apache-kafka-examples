package com.btoy.kafka_avro.config.kafka.producer;

import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.domain.event.EmployeeEvent;
import com.btoy.kafka_avro.dto.avro.EmployeeAvro;
import com.btoy.kafka_avro.mapper.EmployeeDataMapper;
import com.btoy.kafka_avro.ports.output.message.KafkaPublishEmployeeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaPublishEmployeeMessageImpl implements KafkaPublishEmployeeMessage {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final EmployeeDataMapper employeeDataMapper;

    @Override
    public void send(EmployeeEvent event) {
        Employee employee = event.getEmployee();
        EmployeeAvro employeeAvro = employeeDataMapper.employeeToEmployeeAvro(employee);
        final String key = UUID.randomUUID().toString();
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(new ProducerRecord<>(key, employeeAvro));
        future.whenCompleteAsync((result, exception) ->{
            RecordMetadata metadata = result.getRecordMetadata();
            if(exception == null){
                log.info("Event with the Topic Name: {} \n Message Offset: {} \n Published Time: {} published SUCCESSFULLY!",
                        metadata.topic(), metadata.offset(), metadata.timestamp());
            } else {
                log.warn("Event with the Topic Name: {} \n Message Offset: {} \n Published Time: {} cannot published. \n Error: {}",
                        metadata.topic(), metadata.offset(), metadata.timestamp(), exception.getLocalizedMessage());
            }
        });
    }

}
