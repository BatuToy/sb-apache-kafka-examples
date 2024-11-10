package com.btoy.kafka_avro.ports.input.service;

import com.btoy.kafka_avro.dto.create.CreateUserCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import jakarta.validation.Valid;

public interface KafkaAvroApplicationService {
    CreateUserResponse createUser(@Valid CreateUserCommand createUserCommand);
}
