package com.btoy.kafka_avro.dataaccess.mapper;

import com.btoy.kafka_avro.dataaccess.entity.EmployeeEntity;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import org.springframework.stereotype.Component;

@Component
public class JpaMapper {

    public EmployeeEntity employeeToEmployeeEntity(Employee employee){
        return EmployeeEntity.builder()
                .employeeId(employee.getId().getValue())
                .age(employee.getAge())
                .dbo(employee.getDbo())
                .email(employee.getEmail())
                .salary(employee.getSalary().getAmount())
                .employeeType(employee.getEmployeeType())
                .build();
    }
}
