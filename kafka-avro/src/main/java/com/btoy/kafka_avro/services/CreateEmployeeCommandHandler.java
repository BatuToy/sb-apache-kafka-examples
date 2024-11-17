package com.btoy.kafka_avro.services;

import com.btoy.kafka_avro.config.kafka.producer.KafkaPublishEmployeeMessageImpl;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateEmployeeResponse;
import com.btoy.kafka_avro.mapper.EmployeeDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
class CreateEmployeeCommandHandler {

    private final EmployeeDataMapper employeeDataMapper;
    private final KafkaPublishEmployeeMessageImpl kafkaPublishUserMessageImpl;
    private final CreateEmployeeHelper createEmployeeHelper;

    @Transactional
    public CreateEmployeeResponse createEmployee(CreateEmployeeCommand createEmployeeCommand) {
        return null;
    }


}
