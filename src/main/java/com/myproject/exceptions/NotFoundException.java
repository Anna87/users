package com.myproject.exceptions;

public class NotFoundException extends RuntimeException { //TODO @ControllerAdvice
    public NotFoundException(String message) {
        super(message);
    }
}
