package com.kristileka.eucurrencyconverter.service.db;

import com.kristileka.eucurrencyconverter.service.db.entities.ExchangeRecord;

import java.util.List;

public interface CurrencyManualRepository {

    void saveAllCurrenciesBatchCallable(List<ExchangeRecord> exchangeRecords);

    void saveAll(List<ExchangeRecord> exchangeRecords);
}
