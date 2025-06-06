package com.btoy.kafka_avro.common.exception;

public abstract class DomainException extends RuntimeException{
    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
