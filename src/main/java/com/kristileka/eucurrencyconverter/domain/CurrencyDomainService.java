package com.kristileka.eucurrencyconverter.domain;

import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;
import com.kristileka.eucurrencyconverter.dto.request.CurrencyConverterRequest;
import com.kristileka.eucurrencyconverter.dto.response.CurrencyConverterResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponse;

import java.util.List;
import java.util.Optional;


public interface CurrencyDomainService {
    void updateCurrencies(List<ExchangeRecordDTO> exchangeRecordList);

    DailyCurrencyResponse getCurrenciesByDate(Optional<String> date);

    CurrencyConverterResponse convertCurrency(CurrencyConverterRequest body);
}
