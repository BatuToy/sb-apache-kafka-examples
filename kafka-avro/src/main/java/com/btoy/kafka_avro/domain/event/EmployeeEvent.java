package com.btoy.kafka_avro.domain.event;

import com.btoy.kafka_avro.common.event.DomainEvent;
import com.btoy.kafka_avro.domain.aggregate.Employee;

import java.time.ZonedDateTime;

public abstract class EmployeeEvent implements DomainEvent<Employee> {
    private final Employee employee;
    private ZonedDateTime zonedDateTime;

    public EmployeeEvent(Employee employee, ZonedDateTime zonedDateTime) {
        this.employee = employee;
        this.zonedDateTime = zonedDateTime;
    }

    public Employee getEmployee() {
        return employee;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
