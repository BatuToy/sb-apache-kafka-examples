package com.btoy.kafka_avro.domain.event;

import com.btoy.kafka_avro.domain.aggregate.Employee;

import java.time.ZonedDateTime;

public class EmployeeCreatedEvent extends EmployeeEvent {
    public EmployeeCreatedEvent(Employee employee, ZonedDateTime zonedDateTime) {
        super(employee, zonedDateTime);
    }
}
