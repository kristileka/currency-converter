package com.kristileka.eucurrencyconverter.service.filesystem.impl;

import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;
import com.kristileka.eucurrencyconverter.service.filesystem.CsvManagerService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvManagerServiceImpl implements CsvManagerService {

    @Override
    public List<ExchangeRecordDTO> readCsvExchangeRecords(String path) {
        List<ExchangeRecordDTO> currencyData = new ArrayList<>();
        try {
            FileReader filereader = new FileReader(path);
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();

            List<String[]> allData = csvReader.readAll();

            String[] currencies = allData.get(0);
            for (int i = 1; i < allData.size(); i++) {
                String[] row = allData.get(i);
                for (int j = 1; j < row.length - 1; j++) {
                    String cell = row[j];
                    double amount = 0.0;
                    if (!cell.equalsIgnoreCase("n/a") && !cell.isEmpty()) {
                        amount = Double.parseDouble(cell);
                    }
                    currencyData.add(new ExchangeRecordDTO(LocalDate.parse(row[0]), currencies[j], amount));
                }
            }
        } catch (IOException | CsvException ignored) {
        }
        return currencyData;
    }
}
