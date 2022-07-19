package com.kristileka.eucurrencyconverter.core;

import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;

import java.util.List;


public interface CurrencyBusiness {
    void updateCurrencies(List<ExchangeRecordDTO> exchangeRecordList);
}
