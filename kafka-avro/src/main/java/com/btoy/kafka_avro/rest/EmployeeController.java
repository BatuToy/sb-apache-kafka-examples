package com.btoy.kafka_avro.rest;

import com.btoy.kafka_avro.common.response.AppResponse;
import com.btoy.kafka_avro.dto.create.CreateEmployeeCommand;
import com.btoy.kafka_avro.dto.create.CreateEmployeeResponse;
import com.btoy.kafka_avro.ports.input.service.KafkaAvroApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final KafkaAvroApplicationService kafkaAvroApplicationService;

    @PostMapping(value = "/create")
    public AppResponse<CreateEmployeeResponse> createEmployee(@Valid @RequestBody CreateEmployeeCommand createEmployeeCommand){
        try {
            CreateEmployeeResponse data = kafkaAvroApplicationService.createEmployee(createEmployeeCommand);
            return new AppResponse<>(HttpStatus.CREATED, data,
                    "Employee created successfully with id: " + data.getEmployeeId());
        } catch (Exception exc){
           return new AppResponse<>(HttpStatus.BAD_REQUEST, exc.getLocalizedMessage());
        }
    }
}
