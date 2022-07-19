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

@Service
public class CurrencyBusinessImpl implements CurrencyBusiness {
    Logger logger = LoggerFactory.getLogger(CurrencyBusinessImpl.class);

    @Autowired
    ExchangeRecordRepository exchangeRepository;

    @Override
    public void updateCurrencies(List<ExchangeRecordDTO> exchangeRecordList) {
        logger.info("Currency Updater has started.");
        List<ExchangeRecord> exchangeRecords = exchangeRecordList.stream().map(record ->
                new ExchangeRecord(UUID.randomUUID().toString(), record.getDate(), record.getCurrency(), record.getAmount())
        ).toList();
        if (!checkIfRedisHasLatestData(exchangeRecordList)) {
            logger.info(".");
            List<ExchangeRecord> oldExchangeRecords = exchangeRepository.findAll();
            exchangeRepository.saveAll(exchangeRecords);
            exchangeRepository.deleteAll(oldExchangeRecords);
        } else {

        }
    }


    private boolean checkIfRedisHasLatestData(List<ExchangeRecordDTO> exchangeRecordList) {
        List<ExchangeRecord> beginDate = exchangeRepository.findAllByDate(exchangeRecordList.get(0).getDate());
        List<ExchangeRecord> randomDate = exchangeRepository.findAllByDate(exchangeRecordList.get(new Random().nextInt(exchangeRecordList.size() - 1)).getDate());
        List<ExchangeRecord> endDate = exchangeRepository.findAllByDate(exchangeRecordList.get(exchangeRecordList.size() - 1).getDate());
        return beginDate.isEmpty() && endDate.isEmpty() && randomDate.isEmpty();
    }
}
