package com.kristileka.eucurrencyconverter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionManager extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<Object> exceptionHandler(CustomException exception) {
        return mapException(exception);
    }

    private ResponseEntity<Object> mapException(CustomException exception) {
        return switch (exception.type) {
            case CURRENCY_NOT_FOUND ->
                    new ResponseEntity<>(new ErrorResponse("Currency not found", 404, "Double check your currency, if it is correct."), HttpStatus.NOT_FOUND);
            case DATE_NOT_PARSABLE ->
                    new ResponseEntity<>(new ErrorResponse("Date is parsable", 400, "Date is wrong or bad format. Make sure is yyyy-MM-dd"), HttpStatus.BAD_REQUEST);
            case DATE_NOT_FOUND ->
                    new ResponseEntity<>(new ErrorResponse("Date not found", 404, "Date cannot be found, make sure the dates are within weekdays."), HttpStatus.NOT_FOUND);
            case CURRENCY_OR_DATE_NOT_FOUND ->
                    new ResponseEntity<>(new ErrorResponse("Currency or date not found", 404, "Check if currency is correct and date is within weekdays."), HttpStatus.NOT_FOUND);
        };

    }

}
