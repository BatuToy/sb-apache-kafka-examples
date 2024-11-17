package com.btoy.kafka_avro.domain.event;

import com.btoy.kafka_avro.domain.aggregate.Employee;

import java.time.ZonedDateTime;

public class EmployeeJobAssignedEvent extends EmployeeEvent {
    public EmployeeJobAssignedEvent(Employee employee, ZonedDateTime zonedDateTime) {
        super(employee, zonedDateTime);
    }
}
