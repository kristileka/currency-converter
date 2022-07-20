package com.kristileka.eucurrencyconverter.mappers;

import com.kristileka.eucurrencyconverter.dto.request.CurrencyConverterRequest;
import com.kristileka.eucurrencyconverter.dto.response.CurrencyConverterResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.service.db.entities.ExchangeRecord;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyServiceMapper {
    DailyCurrencyResponse mapDailyCurrencyResponse(LocalDate localDate, List<ExchangeRecord> dailyRecords);

    CurrencyConverterResponse mapConvertedCurrency(CurrencyConverterRequest body, Double convertedAmount);
}
