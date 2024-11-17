package com.btoy.kafka_avro.dataaccess.jpa;

import com.btoy.kafka_avro.dataaccess.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, UUID> {
}
