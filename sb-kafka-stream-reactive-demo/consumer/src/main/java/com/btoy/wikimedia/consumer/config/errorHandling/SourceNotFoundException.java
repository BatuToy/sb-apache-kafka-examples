package com.btoy.wikimedia.consumer.config.errorHandling;

import org.springframework.stereotype.Component;

public class SourceNotFoundException extends RuntimeException{

    public SourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }

    public SourceNotFoundException(String message){
        super(message);
    }
}
