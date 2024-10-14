package com.btoy.wikimedia.consumer.config.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(SourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSourceNotFoundException(SourceNotFoundException exc){
        return ResponseEntity.ok(
                ErrorResponse
                        .builder()
                        .errorDate(LocalDateTime.now())
                        .message(exc.getLocalizedMessage())
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build()
        );
    }
}
