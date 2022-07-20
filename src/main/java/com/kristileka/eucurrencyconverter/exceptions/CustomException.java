package com.kristileka.eucurrencyconverter.exceptions;

public class CustomException extends RuntimeException {
    ExceptionType type;

    public CustomException() {
    }

    public ExceptionType getType() {
        return type;
    }

    public void setType(ExceptionType type) {
        this.type = type;
    }

    public CustomException(ExceptionType type) {
        this.type = type;
    }
}
