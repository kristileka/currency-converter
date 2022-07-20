package com.kristileka.eucurrencyconverter.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    String message;
    String detailedMessage;
    int code;

    List<String> errors = new ArrayList<>();

    public ErrorResponse(String message, int code, String detailedMessage) {
        this.message = message;
        this.code = code;
        this.detailedMessage = detailedMessage;
        this.errors.add(message);
    }

    public ErrorResponse(String message, int code, String detailedMessage, List<String> errors) {
        this.message = message;
        this.code = code;
        this.detailedMessage = detailedMessage;
        this.errors = errors;
    }

    public ErrorResponse() {
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
