package com.btoy.kafka_avro.exception;

public class EmployeeDomainException extends RuntimeException{
    public EmployeeDomainException(String message) {
        super(message);
    }

    public EmployeeDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
