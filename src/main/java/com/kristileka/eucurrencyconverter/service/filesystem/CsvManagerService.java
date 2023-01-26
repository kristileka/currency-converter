package com.kristileka.eucurrencyconverter.service.filesystem;

import com.kristileka.eucurrencyconverter.domain.dto.CurrencyRecordDTO;

import java.util.List;

public interface CsvManagerService {
    List<CurrencyRecordDTO> readCsvCurrencyRecords(String path);
}
