package com.kristileka.eucurrencyconverter.extensions;

import com.kristileka.eucurrencyconverter.config.exceptions.CustomException;
import com.kristileka.eucurrencyconverter.config.exceptions.ExceptionType;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionsTest {

    @Test
    void createSubList() {
        List<String> testList = List.of("1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1");
        List<List<String>> newList = Extensions.createSubList(testList, 5);
        assertEquals(5, newList.get(0).size());
        assertEquals(5, newList.get(1).size());
    }

    @Test
    void getDate() {
        Date newDate = Extensions.getDate(LocalDate.parse("2022-02-12"));
        assertEquals("2022-02-12", newDate.toString());
    }

    @Test
    void validateDatesFail() {
        CustomException exception = assertThrows(CustomException.class,
                () -> Extensions.validateDates("2022-12-02", "2022-13-02"));
        ExceptionType expectedType = ExceptionType.DATE_NOT_PARSABLE;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

}