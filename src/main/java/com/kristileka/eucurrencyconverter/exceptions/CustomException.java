package com.kristileka.eucurrencyconverter.exceptions;

public class CustomException extends RuntimeException {
    ExceptionType type;

    public CustomException() {
    }

    public CustomException(ExceptionType type) {
        this.type = type;
    }
}
