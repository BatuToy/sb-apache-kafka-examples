package com.btoy.kafka_avro.ports.input.service;

import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateEmployeeResponse;
import jakarta.validation.Valid;

public interface KafkaAvroApplicationService {
    CreateEmployeeResponse createEmployee(@Valid CreateEmployeeCommand createUserCommand);
}
