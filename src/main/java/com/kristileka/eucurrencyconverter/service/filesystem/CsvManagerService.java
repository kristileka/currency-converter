package com.kristileka.eucurrencyconverter.service.filesystem;

import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;

import java.util.List;

public interface CsvManagerService {
    List<ExchangeRecordDTO> readCsvExchangeRecords(String path);
}
