package com.kristileka.eucurrencyconverter.domain.impl;

import com.kristileka.eucurrencyconverter.dto.request.average.CurrencyAverageRequest;
import com.kristileka.eucurrencyconverter.dto.request.conversion.CurrencyConversionRequest;
import com.kristileka.eucurrencyconverter.dto.request.record.CurrencyRecordRequest;
import com.kristileka.eucurrencyconverter.dto.response.average.CurrencyAverageResponse;
import com.kristileka.eucurrencyconverter.dto.response.conversion.CurrencyConversionResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.dto.response.record.CurrencyRecordResponse;
import com.kristileka.eucurrencyconverter.exceptions.CustomException;
import com.kristileka.eucurrencyconverter.exceptions.ExceptionType;
import com.kristileka.eucurrencyconverter.mappers.CurrencyServiceMapper;
import com.kristileka.eucurrencyconverter.mappers.impl.CurrencyServiceMapperImpl;
import com.kristileka.eucurrencyconverter.service.db.CurrencyManualRepository;
import com.kristileka.eucurrencyconverter.service.db.CurrencyRepository;
import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyDomainServiceImplTest {
    private final CurrencyServiceMapper currencyServiceMapper = new CurrencyServiceMapperImpl();
    private final CurrencyManualRepository currencyManualRepository = Mockito.mock(CurrencyManualRepository.class);
    private final CurrencyRepository currencyRepository = Mockito.mock(CurrencyRepository.class);

    @Test
    void noUpdatedCurrencies() {

        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findAll()).thenReturn(
                List.of()
        );
        boolean response = currencyDomainService.updateCurrencies(List.of());
        assertFalse(response);
    }

    @Test
    void updatedCurrencies() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findAll()).thenReturn(
                List.of(new CurrencyRecord())
        );
        boolean response = currencyDomainService.updateCurrencies(List.of());
        assertTrue(response);
    }

    @Test
    void getCurrencyByDateWillThrowParse() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.getCurrenciesByDate(Optional.of("asdasd")));
        ExceptionType expectedType = ExceptionType.DATE_NOT_PARSABLE;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getCurrencyByDateWillThrowEmpty() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findAllByDate(LocalDate.parse("2023-02-20"))).thenReturn(
                List.of()
        );
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.getCurrenciesByDate(Optional.of("2023-02-20")));
        ExceptionType expectedType = ExceptionType.DATE_NOT_FOUND;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getCurrencyByDateEmptySuccess() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findAllByDate(LocalDate.parse("2022-02-20"))).thenReturn(
                List.of(new CurrencyRecord(LocalDate.now(), "EUR", 1.0))
        );
        DailyCurrencyResponse response = currencyDomainService.getCurrenciesByDate(Optional.of("2022-02-20"));
        int expectedSize = 1;
        double expectedAmount = 1.0;
        String expectedCurrency = "EUR";
        String expectedDate = "2022-02-20";
        assertEquals(expectedSize, response.getCurrencyList().size());
        assertEquals(expectedCurrency, response.getCurrencyList().get(0).getCurrency());
        assertEquals(expectedAmount, response.getCurrencyList().get(0).getAmount());
        assertEquals(expectedDate, response.getDate().toString());
    }

    @Test
    void convertCurrencyWillThrowParse() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.convertCurrency(new CurrencyConversionRequest("asd", "asd", "asd", 2.0)));
        ExceptionType expectedType = ExceptionType.DATE_NOT_PARSABLE;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void convertCurrencyWillThrowEmpty() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findByDateAndCurrency(LocalDate.parse("2022-02-20"), "EUR")).thenReturn(
                null
        );
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.convertCurrency(new CurrencyConversionRequest("2022-02-20", "EUR", "USD", 2.0)));

        ExceptionType expectedType = ExceptionType.CURRENCY_OR_DATE_NOT_FOUND;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void convertCurrencyWillWork() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findByDateAndCurrency(LocalDate.parse("2022-02-20"), "EUR")).thenReturn(
                new CurrencyRecord(LocalDate.parse("2022-02-20"), "EUR", 1.0)
        );
        Mockito.when(currencyRepository.findByDateAndCurrency(LocalDate.parse("2022-02-20"), "USD")).thenReturn(
                new CurrencyRecord(LocalDate.parse("2022-02-20"), "USD", 1.2)
        );

        CurrencyConversionResponse response =
                currencyDomainService.convertCurrency(new CurrencyConversionRequest("2022-02-20", "EUR", "USD", 2.0));
        // 2 EURO / 1 = 2 * 1.2 = 2.4 DOLLAR
        double expectedConversion = 2.4;
        String expectedCurrency = "EUR";
        String expectedTargetCurrency = "USD";
        String expectedDate = "2022-02-20";
        assertEquals(expectedConversion, response.getConvertedAmount());
        assertEquals(expectedDate, response.getDate().toString());
        assertEquals(expectedTargetCurrency, response.getTargetCurrency());
        assertEquals(expectedCurrency, response.getCurrency());
    }


    @Test
    void getCurrencyRecordWillThrowParse() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.getCurrencyRecord(new CurrencyRecordRequest("asd", "asd", "asd")));
        ExceptionType expectedType = ExceptionType.DATE_NOT_PARSABLE;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getCurrencyRecordWillThrowEmpty() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findRecordRate("EUR", LocalDate.parse("2022-02-20"), LocalDate.parse("2022-02-20"))).thenReturn(
                null
        );
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.getCurrencyRecord(new CurrencyRecordRequest("2022-02-20", "2022-02-20", "EUR")));

        ExceptionType expectedType = ExceptionType.CURRENCY_OR_DATE_NOT_FOUND;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getCurrencyRecord() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findRecordRate("EUR", LocalDate.parse("2022-02-20"), LocalDate.parse("2022-02-20"))).thenReturn(
                new CurrencyRecord(LocalDate.parse("2022-02-26"), "EUR", 1.2)
        );
        CurrencyRecordResponse response = currencyDomainService.getCurrencyRecord(new CurrencyRecordRequest("2022-02-20", "2022-02-20", "EUR"));
        double expectedAmount = 1.2;
        String expectedCurrency = "EUR";
        String expectedDate = "2022-02-26";
        assertEquals(expectedAmount, response.getAmount());
        assertEquals(expectedCurrency, response.getCurrency());
        assertEquals(expectedDate, response.getRecordDate());
    }


    @Test
    void getCurrencyAverageWillThrowParse() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.getCurrencyAverage(new CurrencyAverageRequest("asd", "asd", "asd")));
        ExceptionType expectedType = ExceptionType.DATE_NOT_PARSABLE;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getCurrencyAverageWillThrowEmpty() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findAverageRate("EUR", LocalDate.parse("2022-02-20"), LocalDate.parse("2022-02-20"))).thenReturn(
                null
        );
        CustomException exception = assertThrows(CustomException.class,
                () -> currencyDomainService.getCurrencyAverage(new CurrencyAverageRequest("2022-02-20", "2022-02-20", "EUR")));

        ExceptionType expectedType = ExceptionType.CURRENCY_OR_DATE_NOT_FOUND;
        ExceptionType actualType = exception.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getCurrencyAverage() {
        CurrencyDomainServiceImpl currencyDomainService = new CurrencyDomainServiceImpl(currencyServiceMapper, currencyManualRepository, currencyRepository);
        Mockito.when(currencyRepository.findAverageRate("EUR", LocalDate.parse("2022-02-20"), LocalDate.parse("2022-02-20"))).thenReturn(
                2.2
        );
        CurrencyAverageResponse response = currencyDomainService.getCurrencyAverage(new CurrencyAverageRequest("2022-02-20", "2022-02-20", "EUR"));
        double expectedAmount = 2.2;
        String expectedCurrency = "EUR";
        assertEquals(expectedAmount, response.getAverageRate());
        assertEquals(expectedCurrency, response.getCurrency());
    }
}