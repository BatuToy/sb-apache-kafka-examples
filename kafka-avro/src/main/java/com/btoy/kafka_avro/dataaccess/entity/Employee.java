package com.btoy.kafka_avro.dataaccess.entity;

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
public class Employee {

    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private Date dbo;
    private EmployeeType employeeType;
    private BigDecimal salary;
}
