package com.btoy.kafka_avro.mapper;

import com.btoy.kafka_avro.dto.create.CreateUserCommand;
import com.btoy.kafka_avro.dto.create.CreateUserResponse;
import com.btoy.kafka_avro.domain.aggregate.Employee;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {

//    public CreateUserResponse createUserCommandToCreateUserResponse(CreateUserCommand createUserCommand, String message){
//        return CreateUserResponse.builder()
//                .email(createUserCommand.getEmail())
//                .userType(createUserCommand.getUserType())
//                .message(message)
//                .build();
//    }

    public Employee createUserCommandToUser(CreateUserCommand createUserCommand) {
        return Employee.builder()
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .age(createUserCommand.getAge())
                .email(createUserCommand.getEmail())
                .dbo(createUserCommand.getDbo())
                .userType(createUserCommand.getUserType())
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(Employee employee, String message){
        return CreateUserResponse.builder()
                .email(employee.getEmail())
                .userType(employee.getUserType())
                .message(message)
                .build();
    }

}
