package com.kristileka.eucurrencyconverter.service.filesystem;

import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;

import java.util.List;

public interface CsvManagerService {
    List<ExchangeRecord> readCsvExchangeRecords(String path);
}
