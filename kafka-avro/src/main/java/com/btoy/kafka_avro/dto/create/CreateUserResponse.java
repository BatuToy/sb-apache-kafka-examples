package com.btoy.kafka_avro.dto.create;

import com.btoy.kafka_avro.domain.valueObject.EmployeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponse {
    private String email;
    private EmployeeType userType;
    private String message;
}
