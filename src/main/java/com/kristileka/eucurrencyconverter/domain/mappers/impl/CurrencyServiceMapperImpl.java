package com.kristileka.eucurrencyconverter.domain.mappers.impl;

import com.kristileka.eucurrencyconverter.domain.dto.request.average.CurrencyAverageRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.conversion.CurrencyConversionRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.record.CurrencyRecordRequest;
import com.kristileka.eucurrencyconverter.domain.dto.response.average.CurrencyAverageResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.conversion.CurrencyConversionResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.record.CurrencyRecordResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.daily.DailyCurrencyResponseData;
import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;
import com.kristileka.eucurrencyconverter.domain.mappers.CurrencyServiceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceMapperImpl implements CurrencyServiceMapper {
    @Override
    public DailyCurrencyResponse mapDailyCurrencyResponse(LocalDate localDate, List<CurrencyRecord> dailyRecords) {
        DailyCurrencyResponse dailyCurrencyResponse = new DailyCurrencyResponse();
        dailyCurrencyResponse.setBaseCurrency("EUR");
        dailyCurrencyResponse.setDate(localDate);
        dailyCurrencyResponse.setCurrencyList(dailyRecords.stream()
                .sorted(Comparator.comparing(CurrencyRecord::getCurrency)).map(currencyRecord
                        -> new DailyCurrencyResponseData(currencyRecord.getCurrency(),
                        currencyRecord.getAmount())).collect(Collectors.toList()));
        return dailyCurrencyResponse;
    }

    @Override
    public CurrencyConversionResponse mapConvertedCurrency(CurrencyConversionRequest body, Double convertedAmount) {
        return new CurrencyConversionResponse(LocalDate.parse(body
                .getDate()),
                body.getCurrency(),
                body.getTargetCurrency(), body.getAmount(), convertedAmount);
    }

    @Override
    public CurrencyRecordResponse mapBestRecord(CurrencyRecord currencyRecord, CurrencyRecordRequest body) {
        return new CurrencyRecordResponse(currencyRecord.getCurrency(),
                currencyRecord.getAmount(), body.getStartDate(), body.getEndDate(), currencyRecord.getDate().toString());
    }

    @Override
    public CurrencyAverageResponse mapAverageRate(Double averageRate, CurrencyAverageRequest body) {
        return new CurrencyAverageResponse(body.getCurrency(), averageRate, body.getStartDate(), body.getEndDate());
    }

}
