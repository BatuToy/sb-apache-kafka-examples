package com.btoy.kafka_avro.dto.create;


import com.btoy.kafka_avro.common.valueobject.EmployeeType;
import com.btoy.kafka_avro.domain.valueObject.RoleId;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeCommand {
    @NotNull
    private RoleId roleId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private EmployeeType employeeType;
    private Date dbo;
    private int age;

}
