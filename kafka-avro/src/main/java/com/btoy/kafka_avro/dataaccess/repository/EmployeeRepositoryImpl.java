package com.btoy.kafka_avro.dataaccess.repository;

import com.btoy.kafka_avro.dataaccess.jpa.EmployeeJpaRepository;
import com.btoy.kafka_avro.dataaccess.mapper.JpaMapper;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.ports.output.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeJpaRepository employeeJpaRepository;
    private final JpaMapper jpaMapper;

    @Override
    public Employee save(Employee employee) {
        employeeJpaRepository.save(jpaMapper.domainEmployeeToEmployeeEntity(employee));
        return employee;
    }
}
