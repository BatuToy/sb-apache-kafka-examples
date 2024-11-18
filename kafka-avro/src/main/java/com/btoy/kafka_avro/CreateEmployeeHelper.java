package com.btoy.kafka_avro;

import com.btoy.kafka_avro.domain.EmployeeDomainService;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import com.btoy.kafka_avro.domain.event.EmployeeCreatedEvent;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.exception.EmployeeApplicationException;
import com.btoy.kafka_avro.mapper.EmployeeDataMapper;
import com.btoy.kafka_avro.ports.output.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class CreateEmployeeHelper {

    private final EmployeeDataMapper employeeDataMapper;
    private final EmployeeDomainService employeeDomainService;
    private final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeCreatedEvent persistEmployee(CreateEmployeeCommand createEmployeeCommand){
        Employee employee = employeeDataMapper.createEmployeeCommandToEmployee(createEmployeeCommand);
        EmployeeCreatedEvent employeeCreatedEvent = employeeDomainService.validateAndInitializeEmployee(employee);
        saveEmployee(employee);
        log.info("Employee saved to the persisted successfully with employee id: {}", employee.getId().getValue());
        return employeeCreatedEvent;
    }

    private void saveEmployee(Employee emp) {
        Employee employee = employeeRepository.save(emp);
        if(Objects.isNull(employee)){
            throw new EmployeeApplicationException("Employee can not saved to the database!");
        }
        log.info("Employee was saved to database successfully with employee id: {}", employee.getId().getValue());
    }
}
