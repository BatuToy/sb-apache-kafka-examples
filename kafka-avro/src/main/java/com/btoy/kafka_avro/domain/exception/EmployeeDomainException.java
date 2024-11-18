package com.btoy.kafka_avro.domain.exception;

import com.btoy.kafka_avro.common.exception.DomainException;

public class EmployeeDomainException extends DomainException {
    public EmployeeDomainException(String message) {
        super(message);
    }

    public EmployeeDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
