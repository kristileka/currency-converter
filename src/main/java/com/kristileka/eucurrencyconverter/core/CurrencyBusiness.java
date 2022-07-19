package com.kristileka.eucurrencyconverter.core;

import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;

import java.util.List;


public interface CurrencyBusiness {
    void updateCurrencies(List<ExchangeRecord> exchangeRecordList);
}
