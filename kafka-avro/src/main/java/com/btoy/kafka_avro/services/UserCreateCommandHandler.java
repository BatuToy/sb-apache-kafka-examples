package com.btoy.kafka_avro.services;

import com.btoy.kafka_avro.dto.create.CreateUserCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import com.btoy.kafka_avro.exception.UserDomainException;
import com.btoy.kafka_avro.mapper.UserDataMapper;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
class UserCreateCommandHandler {

    private final UserDataMapper userDataMapper;
    private final UserRepository userRepository;

    public CreateUserResponse createUser(CreateUserCommand createUserCommand){
        Employee user = saveUser(createUserCommand);
        return userDataMapper.userToCreateUserResponse(user, "Employee with id");
    }

    private Employee saveUser(CreateUserCommand createUserCommand){
        Employee employee = userDataMapper.createUserCommandToUser(createUserCommand);
        Optional<Employee> optUser = userRepository.save(employee);
        if(optUser.isEmpty()){
            log.warn("Employee with the id: {} is not in the persist store!");
            throw new UserDomainException("Employee with the id: "+ " " + "is not in the persist store!");
        }
        return optUser.get();
    }
}
