package com.kristileka.eucurrencyconverter.extensions;

import com.kristileka.eucurrencyconverter.exceptions.CustomException;
import com.kristileka.eucurrencyconverter.exceptions.ExceptionType;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Extensions {
    public static <T> List<List<T>> createSubList(List<T> list, int subListSize) {
        List<List<T>> listOfSubList = new ArrayList<>();
        for (int i = 0; i < list.size(); i += subListSize) {
            if (i + subListSize <= list.size()) {
                listOfSubList.add(list.subList(i, i + subListSize));
            } else {
                listOfSubList.add(list.subList(i, list.size()));
            }
        }
        return listOfSubList;
    }

    public static Date getDate(LocalDate localDate) {
        return Date.valueOf(localDate);
    }

    public static void validateDates(String... localDate) {
        try {
            for (String date : localDate) {
                LocalDate.parse(date);
            }
        } catch (DateTimeParseException ignored) {
            throw new CustomException(ExceptionType.DATE_NOT_PARSABLE);
        }
    }

}