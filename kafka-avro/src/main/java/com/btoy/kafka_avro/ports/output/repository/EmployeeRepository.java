package com.btoy.kafka_avro.ports.output.repository;

import com.btoy.kafka_avro.domain.aggregate.Employee;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository {
    Employee save(Employee employee);
}
