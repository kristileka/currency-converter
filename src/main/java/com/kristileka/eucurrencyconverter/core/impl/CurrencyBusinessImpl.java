package com.kristileka.eucurrencyconverter.core.impl;

import com.kristileka.eucurrencyconverter.core.CurrencyBusiness;
import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CurrencyBusinessImpl implements CurrencyBusiness {

    @Autowired
    ExchangeRecordRepository exchangeRepository;

    @Override
    public void updateCurrencies(List<ExchangeRecordDTO> exchangeRecordList) {
        List<ExchangeRecord> exchangeRecords = exchangeRecordList.stream().map(record ->
                new ExchangeRecord(UUID.randomUUID().toString(), record.getDate(), record.getCurrency(), record.getAmount())
        ).toList();
        List<ExchangeRecord> savedExchangeRecords = exchangeRepository.findAll();
//        List<ExchangeRecord> recordsToUpdate = exchangeRecords.stream().filter(
//                exchangeRecord ->
//                        savedExchangeRecords.stream().noneMatch(
//                                savedRecord ->
//                                        savedRecord.getDate() == exchangeRecord.getDate()
//                                                && savedRecord.getCurrency().equals(exchangeRecord.getCurrency())
//                        )
//        ).toList();

        exchangeRepository.saveAll(exchangeRecords);
    }
}
