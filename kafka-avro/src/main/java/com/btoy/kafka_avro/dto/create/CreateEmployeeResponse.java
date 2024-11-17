package com.btoy.kafka_avro.dto.create;

import com.btoy.kafka_avro.common.valueobject.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
    private String email;
    private EmployeeType userType;
    private String message;
}
