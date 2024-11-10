package com.btoy.kafka_avro.domain.aggregate;

import com.btoy.kafka_avro.common.AggregateRoot;
import com.btoy.kafka_avro.exception.UserDomainException;
import com.btoy.kafka_avro.domain.valueObject.EmployeeType;
import com.btoy.kafka_avro.domain.valueObject.EmployeeId;
import com.btoy.kafka_avro.domain.valueObject.Money;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

// Find more domain logic about employee aggregate and around relational entities with support of ValueObjects

@Getter
@Setter
@Builder
@ToString
public class Employee extends AggregateRoot<EmployeeId> {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;
    private final ZonedDateTime dbo;

    private EmployeeType userType;
    // Salary can always changeable while new contracts are preparing.
    private Money salary;

    public void initializeEmployee(){
        super.setId(new EmployeeId(UUID.randomUUID()));
        setUserType(EmployeeType.PENDING_TYPE_ASSIGNMENT);
    }

    public void validateEmployee(){
        if(userType != null && super.id != null){
            throw new UserDomainException("Employee with id: " + super.getId().getValue() + "was already initialized!");
        }
    }

    private void validateSalary(){
        if(salary == null || !salary.isGreaterThenZero()){
            throw new UserDomainException("Salary can not be null or lesser then or equal to zero!");
        }
    }

    public Employee(EmployeeId employeeId, EmployeeType userType, ZonedDateTime dbo, String email, int age, String lastName, String firstName) {
        super.setId(employeeId);
        this.userType = userType;
        this.dbo = dbo;
        this.email = email;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
    }


}
