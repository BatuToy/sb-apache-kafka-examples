package com.btoy.kafka_avro.ports.output.repository;

import com.btoy.kafka_avro.domain.aggregate.Employee;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface EmployeeRepository {
    Optional<Employee> save(@NotNull Employee employee);
}
