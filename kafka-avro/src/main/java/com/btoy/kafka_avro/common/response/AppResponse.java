package com.btoy.kafka_avro.common.response;

import org.springframework.http.HttpStatus;

public class AppResponse<T> {
    private final HttpStatus status;
    private T data;
    private String infoMessage;
    private String errorMessage;

    public AppResponse(HttpStatus status, T data, String infoMessage) {
        this.status = status;
        this.data = data;
        this.infoMessage = infoMessage;
    }

    public AppResponse(HttpStatus status, String errorMessage) {
        this.errorMessage = errorMessage;
        this.status = status;
    }
}
