package com.kristileka.eucurrencyconverter.core.impl;

import com.kristileka.eucurrencyconverter.core.CurrencyBusiness;
import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CurrencyBusinessImpl implements CurrencyBusiness {
    Logger logger = LoggerFactory.getLogger(CurrencyBusinessImpl.class);

    @Autowired
    ExchangeRecordRepository exchangeRepository;

    @Override
    public void updateCurrencies(List<ExchangeRecordDTO> exchangeRecordList) {
        logger.info("Currency Updater has started.");
        logger.info("Retrieving current stored records.");
        List<String> storedDatesCurrencies = exchangeRepository.findAll().stream().map(exchangeRecord ->
                exchangeRecord.getDate() + exchangeRecord.getCurrency()).toList();
        logger.info("Filtering not stored records.");
        List<ExchangeRecordDTO> toUpdate = exchangeRecordList.stream().filter(exchangeRecord ->
                !storedDatesCurrencies.contains(exchangeRecord.getDate() + exchangeRecord.getCurrency())).toList();
        List<ExchangeRecord> exchangeRecords = toUpdate.stream().map(record ->
                new ExchangeRecord(UUID.randomUUID().toString(), record.getDate(), record.getCurrency(), record.getAmount())
        ).toList();
        logger.info("Storing new records.");
        exchangeRepository.saveAll(exchangeRecords);
        logger.info("Finished updating records");

    }

}
