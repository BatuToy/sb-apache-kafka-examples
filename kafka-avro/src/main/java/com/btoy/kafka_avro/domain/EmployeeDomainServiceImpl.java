package com.btoy.kafka_avro.domain;

import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.domain.event.EmployeeJobAssignedEvent;
import com.btoy.kafka_avro.domain.event.EmployeeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Slf4j
@Service
public class EmployeeDomainServiceImpl implements EmployeeDomainService{

    @Override
    public EmployeeCreatedEvent validateAndInitializeEmployee(Employee employee) {
        employee.validateEmployee();
        employee.initializeEmployee();
        log.info("Employee created validated and initialized successfully with id: {}", employee.getId().getValue());
        return new EmployeeCreatedEvent(employee, ZonedDateTime.now());
    }

    @Override
    public EmployeeJobAssignedEvent assignJobToEmployee(Employee employee) {
        employee.assignJob(employee.getEmployeeType());
        log.info("Employee has assigned to job successfully with id: {}", employee.getId().getValue());
        return new EmployeeJobAssignedEvent(employee, ZonedDateTime.now());
    }
}
