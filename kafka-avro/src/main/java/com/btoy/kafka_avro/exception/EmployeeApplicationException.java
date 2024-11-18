package com.btoy.kafka_avro.exception;

import com.btoy.kafka_avro.common.exception.DomainException;

public class EmployeeApplicationException extends DomainException {
    public EmployeeApplicationException(String message) {
        super(message);
    }

    public EmployeeApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
