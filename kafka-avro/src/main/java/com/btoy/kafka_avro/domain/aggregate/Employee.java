package com.btoy.kafka_avro.domain.aggregate;

import com.btoy.kafka_avro.common.entity.AggregateRoot;
import com.btoy.kafka_avro.common.valueobject.RoleType;
import com.btoy.kafka_avro.domain.entity.Role;
import com.btoy.kafka_avro.domain.valueObject.RoleId;
import com.btoy.kafka_avro.domain.exception.EmployeeDomainException;
import com.btoy.kafka_avro.common.valueobject.EmployeeType;
import com.btoy.kafka_avro.domain.valueObject.EmployeeId;
import com.btoy.kafka_avro.common.valueobject.Money;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Setter
public class Employee extends AggregateRoot<EmployeeId> {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;
    private final Date dbo;
    private EmployeeType employeeType;
    private Role role;
    private Money salary;


    public void initializeEmployee(){
        super.setId(new EmployeeId(UUID.randomUUID()));
        this.employeeType = EmployeeType.WAITING_ASSIGNMENT;
        initializeRole();
    }

    public void validateEmployee(){
        validate();
        validateSalary();
        validateEmployeeType();
        validateRole();
    }

    public void assignJob(EmployeeType employeeType){
        if(this.employeeType != EmployeeType.WAITING_ASSIGNMENT){
            throw new EmployeeDomainException("Employee type is not correct state for job assignment with employee id: "
             + super.getId().getValue());
        }
        this.employeeType = employeeType;
    }

    private void validate(){
        if(employeeType != null && super.getId() != null){
            throw new EmployeeDomainException("Employee with id: " + super.getId().getValue() + "was already initialized!");
        }
    }

    private void validateSalary(){
        if(salary == null || !salary.isGreaterThenZero()){
            throw new EmployeeDomainException("Salary can not be null or lesser then or equal to zero!");
        }
    }

    private void validateEmployeeType(){
        if(this.employeeType != EmployeeType.WAITING_ASSIGNMENT){
            throw new EmployeeDomainException("User can not be assign with the status: " + this.employeeType);
        }
    }

    private void validateRole(){
        if(this.role.getRoleType()!= RoleType.PENDING_ROLE_ASSIGNMENT){
            throw new EmployeeDomainException("Employee is not correct state for role type!");
        }
    }

    private void initializeRole(){
        role.initializeRoleAndRoleType(new RoleId( UUID.randomUUID()));
    }

    public Employee(EmployeeId employeeId, Role role, String firstName, String lastName, String email, int age, Date dbo, EmployeeType employeeType, Money salary) {
        super.setId(employeeId);
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.dbo = dbo;
        this.employeeType = employeeType;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Date getDbo() {
        return dbo;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public Role getRole() {
        return role;
    }

    public Money getSalary() {
        return salary;
    }

    private Employee(Builder builder) {
        super.setId(builder.employeeId);
        role = builder.role;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        age = builder.age;
        dbo = builder.dbo;
        setEmployeeType(builder.employeeType);
        setSalary(builder.salary);
    }

    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private EmployeeId employeeId;
        private Role role;
        private String firstName;
        private String lastName;
        private String email;
        private int age;
        private Date dbo;
        private EmployeeType employeeType;
        private Money salary;

        private Builder() {
        }

        public Builder role(Role val){
            role = val;
            return this;
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
