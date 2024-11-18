package com.btoy.kafka_avro.dto.create;

import com.btoy.kafka_avro.common.valueobject.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateEmployeeResponse {
    private UUID employeeId;
    private String email;
    private EmployeeType userType;
    private String message;
}
