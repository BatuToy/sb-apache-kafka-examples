package com.btoy.kafka_avro.ports.output.repository;

import com.btoy.kafka_avro.domain.aggregate.Employee;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<Employee> save(@NotNull Employee employee);
}
