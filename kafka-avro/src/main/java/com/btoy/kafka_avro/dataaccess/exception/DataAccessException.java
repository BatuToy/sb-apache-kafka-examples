package com.btoy.kafka_avro.dataaccess.exception;

public class DataAccessException extends RuntimeException{
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(String message) {
        super(message);
    }
}
