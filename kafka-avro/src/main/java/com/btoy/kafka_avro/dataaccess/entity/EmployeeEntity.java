package com.btoy.kafka_avro.dataaccess.entity;

import com.btoy.kafka_avro.common.valueobject.EmployeeType;
import com.btoy.kafka_avro.domain.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Table(name = "t_employee")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    private UUID employeeId;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "BIRTH_DAY")
    private Date dbo;
    @Column(name = "AGE")
    private int age;
    @Column(name = "EMPLOYEE_TYPE")
    @Enumerated
    private EmployeeType employeeType;
    @OneToOne
    private RoleEntity role;

}
