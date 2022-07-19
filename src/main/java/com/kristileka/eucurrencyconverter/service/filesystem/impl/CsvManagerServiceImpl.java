package com.kristileka.eucurrencyconverter.service.filesystem.impl;

import com.kristileka.eucurrencyconverter.service.filesystem.CsvManagerService;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Collections;
import java.util.List;

@Service
public class CsvManagerServiceImpl implements CsvManagerService {

    @Override
    public List<ExchangeRecord> readCsvExchangeRecords(String path) {
        try {
            File csvFile = new File(path);
            InputStream stream = new FileInputStream(csvFile);
            try (Reader reader = new BufferedReader(new InputStreamReader(stream))) {
                CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                        .withType(ExchangeRecord.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();
                return csvToBean.parse();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
