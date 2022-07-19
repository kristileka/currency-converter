package com.kristileka.eucurrencyconverter.service.filesystem.impl;

import com.kristileka.eucurrencyconverter.extensions.Triple;
import com.kristileka.eucurrencyconverter.service.filesystem.CsvManagerService;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CsvManagerServiceImpl implements CsvManagerService {

    @Override
    public List<Triple<LocalDate, String, String>> readCsvExchangeRecords(String path) {
        List<Triple<LocalDate, String, String>> currencyData = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReaderBuilder(filereader)
                    .build();

            List<String[]> allData = csvReader.readAll();

            String[] currencies = allData.get(0);
            for (int i = 1; i < allData.size(); i++) {
                String[] row = allData.get(i);
                for (int j = 1; j < row.length; j++) {
                    String cell = row[j];
                    currencyData.add(new Triple(LocalDate.parse(row[0]), currencies[j], cell));
                }
            }
        } catch (IOException | CsvException ioException) {
        }

        return Collections.emptyList();
    }
}
