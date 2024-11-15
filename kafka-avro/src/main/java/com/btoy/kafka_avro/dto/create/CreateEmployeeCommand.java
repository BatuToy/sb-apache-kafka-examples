package com.btoy.kafka_avro.dto.create;


import com.btoy.kafka_avro.domain.valueObject.EmployeeType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeCommand {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private Date dbo;

    private int age;
    private EmployeeType employeeType;

}
