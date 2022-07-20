package com.kristileka.eucurrencyconverter.exceptions;

public class ErrorResponse {
    String message;
    String detailedMessage;
    int code;

    public ErrorResponse(String message, int code, String detailedMessage) {
        this.message = message;
        this.code = code;
        this.detailedMessage = detailedMessage;
    }

    public ErrorResponse() {
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
