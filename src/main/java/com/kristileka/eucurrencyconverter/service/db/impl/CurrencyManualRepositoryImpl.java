package com.kristileka.eucurrencyconverter.service.db.impl;

import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;
import com.kristileka.eucurrencyconverter.service.db.CurrencyManualRepository;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static com.kristileka.eucurrencyconverter.extensions.Extensions.createSubList;
import static com.kristileka.eucurrencyconverter.extensions.Extensions.getDate;

@Service
public class CurrencyManualRepositoryImpl implements CurrencyManualRepository {

    @Autowired
    HikariDataSource hikariDataSource;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @Override
    public void saveAll(List<CurrencyRecord> currencyRecords) {
        ExecutorService executorService = Executors.newFixedThreadPool(hikariDataSource.getMaximumPoolSize());
        List<List<CurrencyRecord>> listOfBookSub = createSubList(currencyRecords, batchSize);
        List<Callable<Void>> callables = listOfBookSub.stream().map(sublist -> (Callable<Void>) () -> {
            saveAllCurrenciesBatchCallable(sublist);
            return null;
        }).collect(Collectors.toList());
        try {
            executorService.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAllCurrenciesBatchCallable(List<CurrencyRecord> currencyRecords) {
        String sql = String.format("INSERT INTO %s (currency, date, amount) " + "VALUES (?, ?, ?)", CurrencyRecord.class.getAnnotation(Table.class).name());
        try (Connection connection = hikariDataSource.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            int counter = 0;
            for (CurrencyRecord record : currencyRecords) {
                statement.clearParameters();
                statement.setString(1, record.getCurrency());
                statement.setDate(2, getDate(record.getDate()));
                statement.setDouble(3, record.getAmount());
                statement.addBatch();
                if ((counter + 1) % batchSize == 0 || (counter + 1) == currencyRecords.size()) {
                    statement.executeBatch();
                    statement.clearBatch();
                }
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
