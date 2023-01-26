package com.kristileka.eucurrencyconverter.domain;

import com.kristileka.eucurrencyconverter.domain.dto.CurrencyRecordDTO;
import com.kristileka.eucurrencyconverter.domain.dto.request.average.CurrencyAverageRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.conversion.CurrencyConversionRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.record.CurrencyRecordRequest;
import com.kristileka.eucurrencyconverter.domain.dto.response.average.CurrencyAverageResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.conversion.CurrencyConversionResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.record.CurrencyRecordResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.daily.DailyCurrencyResponse;

import java.util.List;
import java.util.Optional;


public interface CurrencyService {
    Boolean updateCurrencies(List<CurrencyRecordDTO> currencyRecordDTOList);

    DailyCurrencyResponse getCurrenciesByDate(Optional<String> date);

    CurrencyConversionResponse convertCurrency(CurrencyConversionRequest body);

    CurrencyRecordResponse getCurrencyRecord(CurrencyRecordRequest body);

    CurrencyAverageResponse getCurrencyAverage(CurrencyAverageRequest body);
}
