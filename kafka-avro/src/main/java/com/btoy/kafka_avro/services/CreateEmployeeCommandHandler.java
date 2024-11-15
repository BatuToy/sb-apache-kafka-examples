package com.btoy.kafka_avro.services;

import com.btoy.kafka_avro.config.kafka.producer.KafkaPublishEmployeeMessageImpl;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import com.btoy.kafka_avro.exception.UserDomainException;
import com.btoy.kafka_avro.mapper.UserDataMapper;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.ports.output.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
class CreateEmployeeCommandHandler {

    private final UserDataMapper userDataMapper;
    private final EmployeeRepository employeeRepository;
    private final KafkaPublishEmployeeMessageImpl kafkaPublishUserMessageImpl;
    // Could be implemented outbox_t too!
    @Transactional
    public CreateUserResponse createEmployee(CreateEmployeeCommand createEmployeeCommand){
        Employee employee = saveEmployee(createEmployeeCommand);
        kafkaPublishUserMessageImpl.send( userDataMapper.createEmployeeCommandToEmployeeAvro(createEmployeeCommand));
        return userDataMapper.userToCreateUserResponse(employee, "Employee with id: " + employee.getId().getValue() + "has been created!");
    }

    private Employee saveEmployee(CreateEmployeeCommand createEmployeeCommand){
        Employee employee = userDataMapper.createUserCommandToUser(createEmployeeCommand);
        Optional<Employee> optUser = employeeRepository.save(employee);
        if(optUser.isEmpty()){
            throw new UserDomainException("Employee is not in the persist store!");
        }
        return optUser.get();
    }
}
