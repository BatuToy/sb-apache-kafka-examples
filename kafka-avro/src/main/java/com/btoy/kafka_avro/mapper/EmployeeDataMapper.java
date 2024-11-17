package com.btoy.kafka_avro.mapper;

import com.btoy.kafka_avro.domain.event.EmployeeJobAssignedEvent;
import com.btoy.kafka_avro.dto.avro.EmployeeAvro;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateEmployeeResponse;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class EmployeeDataMapper {

    public Employee createEmployeeCommandToEmployee(CreateEmployeeCommand createUserCommand) {
        return Employee.builder()
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .age(createUserCommand.getAge())
                .email(createUserCommand.getEmail())
                .dbo(createUserCommand.getDbo())
                .employeeType(createUserCommand.getEmployeeType())
                .build();
    }

    public CreateEmployeeResponse employeeToCreateEmployeeResponse(Employee employee, String message){
        return CreateEmployeeResponse.builder()
                .email(employee.getEmail())
                .userType(employee.getEmployeeType())
                .message(message)
                .build();
    }

    public EmployeeAvro createEmployeeCommandToEmployeeAvro(CreateEmployeeCommand createEmployeeCommand){
        return EmployeeAvro.builder()
                .setAge(createEmployeeCommand.getAge())
                .setEmail(createEmployeeCommand.getEmail())
                .setFirstName(createEmployeeCommand.getFirstName())
                .setLastName(createEmployeeCommand.getLastName())
                .setIsActive(false)
                .setDbo(createEmployeeCommand.getDbo().getTime())
                .build();
    }

    public CreateEmployeeCommand employeeAvroToCreateEmployeeCommand(EmployeeAvro employeeAvro){
        return CreateEmployeeCommand.builder()
                .firstName(employeeAvro.getFirstName().toString())
                .lastName(employeeAvro.getLastName().toString())
                .email(employeeAvro.getEmail().toString())
                .dbo(longToDate(employeeAvro.getDbo()))
                .age(employeeAvro.getAge())
                //.employeeType()
                .build();
    }

    private Date longToDate(long timestamp){
        Instant instant = Instant.ofEpochMilli(timestamp);
        return Date.from(instant);
    }
    
}
