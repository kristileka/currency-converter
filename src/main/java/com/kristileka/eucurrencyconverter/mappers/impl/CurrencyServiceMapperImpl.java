package com.kristileka.eucurrencyconverter.mappers.impl;

import com.kristileka.eucurrencyconverter.dto.request.CurrencyConverterRequest;
import com.kristileka.eucurrencyconverter.dto.response.CurrencyConverterResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponseData;
import com.kristileka.eucurrencyconverter.mappers.CurrencyServiceMapper;
import com.kristileka.eucurrencyconverter.service.db.entities.ExchangeRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceMapperImpl implements CurrencyServiceMapper {
    @Override
    public DailyCurrencyResponse mapDailyCurrencyResponse(LocalDate localDate, List<ExchangeRecord> dailyRecords) {
        DailyCurrencyResponse dailyCurrencyResponse = new DailyCurrencyResponse();
        dailyCurrencyResponse.setBaseCurrency("EUR");
        dailyCurrencyResponse.setDate(localDate);
        dailyCurrencyResponse.setCurrencyList(dailyRecords.stream()
                .sorted(Comparator.comparing(ExchangeRecord::getCurrency)).map(exchangeRecord
                        -> new DailyCurrencyResponseData(exchangeRecord.getCurrency(),
                        exchangeRecord.getAmount())).collect(Collectors.toList()));
        return dailyCurrencyResponse;
    }

    @Override
    public CurrencyConverterResponse mapConvertedCurrency(CurrencyConverterRequest body, Double convertedAmount) {
        return new CurrencyConverterResponse(LocalDate.parse(body
                .getLocalDate()),
                body.getCurrency(),
                body.getTargetCurrency(), body.getAmount(), convertedAmount);
    }
}
