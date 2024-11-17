package com.btoy.kafka_avro.services;

import com.btoy.kafka_avro.config.kafka.producer.KafkaPublishEmployeeMessageImpl;
import com.btoy.kafka_avro.domain.EmployeeDomainService;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.domain.event.EmployeeCreatedEvent;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.mapper.EmployeeDataMapper;
import com.btoy.kafka_avro.ports.output.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateEmployeeHelper {

    private final EmployeeDataMapper employeeDataMapper;
    private final EmployeeDomainService employeeDomainService;
    private final EmployeeRepository employeeRepository;
    private final KafkaPublishEmployeeMessageImpl kafkaPublishUserMessageImpl;

    @Transactional
    public EmployeeCreatedEvent persistEmployee(CreateEmployeeCommand createEmployeeCommand){
        Employee employee = employeeDataMapper.createEmployeeCommandToEmployee(createEmployeeCommand);
        EmployeeCreatedEvent employeeCreatedEvent = employeeDomainService.validateAndInitializeEmployee(employee);
        return null;
    }

    private Employee saveEmployee(Employee employee){
        return null;
    }
}
