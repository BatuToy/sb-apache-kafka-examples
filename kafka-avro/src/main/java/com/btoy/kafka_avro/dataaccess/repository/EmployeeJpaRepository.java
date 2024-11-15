package com.btoy.kafka_avro.dataaccess.repository;

import com.btoy.kafka_avro.dataaccess.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeJpaRepository extends JpaRepository<UUID, Employee> {
}
