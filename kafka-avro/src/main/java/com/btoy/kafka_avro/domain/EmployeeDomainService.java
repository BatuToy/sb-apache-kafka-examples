package com.btoy.kafka_avro.domain;

import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.domain.event.EmployeeJobAssignedEvent;
import com.btoy.kafka_avro.domain.event.EmployeeCreatedEvent;

public interface EmployeeDomainService {
    EmployeeCreatedEvent validateAndInitializeEmployee(Employee employee);
    EmployeeJobAssignedEvent assignJobToEmployee(Employee employee);
}
