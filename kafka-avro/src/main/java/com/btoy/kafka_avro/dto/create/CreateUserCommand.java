package com.btoy.kafka_avro.dto.create;


import com.btoy.kafka_avro.domain.valueObject.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserCommand {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private long dbo;
    private EmployeeType userType;
}
