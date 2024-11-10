package com.btoy.kafka_avro.services;

import com.btoy.kafka_avro.dto.create.CreateUserCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import com.btoy.kafka_avro.ports.input.service.KafkaAvroApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
@Slf4j
public class KafkaAvroApplicationServiceImpl implements KafkaAvroApplicationService {

    private final UserCreateCommandHandler userCreateCommandHandler;
    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        return userCreateCommandHandler.createUser(createUserCommand);
    }
}
