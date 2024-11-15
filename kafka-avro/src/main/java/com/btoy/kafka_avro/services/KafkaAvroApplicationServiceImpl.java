package com.btoy.kafka_avro.services;

import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import com.btoy.kafka_avro.ports.input.service.KafkaAvroApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Slf4j
@Validated
public class KafkaAvroApplicationServiceImpl implements KafkaAvroApplicationService {

    private final CreateEmployeeCommandHandler createEmployeeCommandHandler;

    @Override
    public CreateUserResponse createEmployee(CreateEmployeeCommand createUserCommand) {
        return createEmployeeCommandHandler.createEmployee(createUserCommand);

    }
}
