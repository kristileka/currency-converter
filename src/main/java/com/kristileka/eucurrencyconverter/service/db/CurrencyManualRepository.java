package com.kristileka.eucurrencyconverter.service.db;

import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;

import java.util.List;

public interface CurrencyManualRepository {

    void saveAllCurrenciesBatchCallable(List<CurrencyRecord> currencyRecords);

    void saveAll(List<CurrencyRecord> currencyRecords);
}
