package com.btoy.kafka_avro.domain.aggregate;

import com.btoy.kafka_avro.common.AggregateRoot;
import com.btoy.kafka_avro.exception.UserDomainException;
import com.btoy.kafka_avro.domain.valueObject.EmployeeType;
import com.btoy.kafka_avro.domain.valueObject.EmployeeId;
import com.btoy.kafka_avro.domain.valueObject.Money;
import lombok.*;

import javax.swing.*;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

// Find more domain logic about employee aggregate and around relational entities with support of ValueObjects

@Getter
@Setter
@ToString
public class Employee extends AggregateRoot<EmployeeId> {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;
    private final Date dbo;

    private EmployeeType employeeType;
    private Money salary;

    private Employee(Builder builder) {
        super.setId(builder.employeeId);
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        age = builder.age;
        dbo = builder.dbo;
        setEmployeeType(builder.employeeType);
        setSalary(builder.salary);
    }

    public void initializeEmployee(){
        super.setId(new EmployeeId(UUID.randomUUID()));
        setEmployeeType(EmployeeType.PENDING_TYPE_ASSIGNMENT);
    }

    public void validateEmployee(){
        if(employeeType != null && super.getId() != null){
            throw new UserDomainException("Employee with id: " + super.getId().getValue() + "was already initialized!");
        }
    }

    public void validateSalary(){
        if(salary == null || !salary.isGreaterThenZero()){
            throw new UserDomainException("Salary can not be null or lesser then or equal to zero!");
        }
    }

    public void assignJob(EmployeeType employeeType){
        if(!(this.employeeType == EmployeeType.PENDING_TYPE_ASSIGNMENT || this.employeeType == EmployeeType.ASSIGNING)){
            throw new UserDomainException("User can not be assign now with the status: " + this.employeeType);
        }
        this.employeeType = EmployeeType.ASSIGNING;
    }

    public Employee(EmployeeId employeeId, String firstName, String lastName, String email, int age, Date dbo, EmployeeType employeeType, Money salary) {
        super.setId(employeeId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.dbo = dbo;
        this.employeeType = employeeType;
        this.salary = salary;
    }


    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private EmployeeId employeeId;
        private String firstName;
        private String lastName;
        private String email;
        private int age;
        private Date dbo;
        private EmployeeType employeeType;

        private Money salary;

        private Builder() {
        }

        public Builder id(EmployeeId val) {
            employeeId = val;
            return this;
        }

        public Builder firstName(String val) {
            firstName = val;
            return this;
        }

        public Builder lastName(String val) {
            lastName = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public Builder age(int val) {
            age = val;
            return this;
        }

        public Builder dbo(Date val) {
            dbo = val;
            return this;
        }

        public Builder employeeType(EmployeeType val) {
            employeeType = val;
            return this;
        }

        public Builder salary(Money val) {
            salary = val;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
