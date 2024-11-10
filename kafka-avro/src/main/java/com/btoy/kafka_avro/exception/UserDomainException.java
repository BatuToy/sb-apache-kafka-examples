package com.btoy.kafka_avro.exception;

public class UserDomainException extends RuntimeException{
    public UserDomainException(String message) {
        super(message);
    }

    public UserDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
