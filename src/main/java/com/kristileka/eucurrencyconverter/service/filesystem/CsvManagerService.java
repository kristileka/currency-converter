package com.kristileka.eucurrencyconverter.service.filesystem;

import com.kristileka.eucurrencyconverter.extensions.Triple;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CsvManagerService {
    List<Triple<LocalDate, String, String>> readCsvExchangeRecords(String path);
}
