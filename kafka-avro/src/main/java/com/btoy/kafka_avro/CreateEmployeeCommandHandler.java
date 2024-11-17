package com.btoy.kafka_avro;

import com.btoy.kafka_avro.config.kafka.producer.KafkaPublishEmployeeMessageImpl;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.domain.event.EmployeeCreatedEvent;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateEmployeeResponse;
import com.btoy.kafka_avro.mapper.EmployeeDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
class CreateEmployeeCommandHandler {

    private final EmployeeDataMapper employeeDataMapper;
    private final KafkaPublishEmployeeMessageImpl kafkaPublishUserMessageImpl;
    private final CreateEmployeeHelper createEmployeeHelper;

    public CreateEmployeeResponse createEmployee(CreateEmployeeCommand createEmployeeCommand) {
        EmployeeCreatedEvent employeeCreatedEvent = createEmployeeHelper.persistEmployee(createEmployeeCommand);
        //kafkaPublishUserMessageImpl.send(employeeCreatedEvent);
        Employee employee = employeeCreatedEvent.getEmployee();
        log.info("Employee created successfully with id: {}", employee.getId().getValue());
        return employeeDataMapper.employeeToCreateEmployeeResponse(employee,
                "Employee created successfully with id: " + employee.getId().getValue());
    }


}
