package com.kristileka.eucurrencyconverter.domain.mappers;

import com.kristileka.eucurrencyconverter.domain.dto.request.average.CurrencyAverageRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.conversion.CurrencyConversionRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.record.CurrencyRecordRequest;
import com.kristileka.eucurrencyconverter.domain.dto.response.average.CurrencyAverageResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.conversion.CurrencyConversionResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.record.CurrencyRecordResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;

import java.time.LocalDate;
import java.util.List;

public interface CurrencyServiceMapper {
    DailyCurrencyResponse mapDailyCurrencyResponse(LocalDate localDate, List<CurrencyRecord> dailyRecords);

    CurrencyConversionResponse mapConvertedCurrency(CurrencyConversionRequest body, Double convertedAmount);

    CurrencyRecordResponse mapBestRecord(CurrencyRecord currencyRecord, CurrencyRecordRequest body);

    CurrencyAverageResponse mapAverageRate(Double averageRate, CurrencyAverageRequest body);
}
