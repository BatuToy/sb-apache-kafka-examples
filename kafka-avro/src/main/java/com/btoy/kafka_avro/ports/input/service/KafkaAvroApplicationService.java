package com.btoy.kafka_avro.ports.input.service;

import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import jakarta.validation.Valid;

public interface KafkaAvroApplicationService {
    CreateUserResponse createEmployee(@Valid CreateEmployeeCommand createUserCommand);
}
