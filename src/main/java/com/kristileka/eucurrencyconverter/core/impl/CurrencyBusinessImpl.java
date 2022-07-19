package com.kristileka.eucurrencyconverter.core.impl;

import com.kristileka.eucurrencyconverter.core.CurrencyBusiness;
import com.kristileka.eucurrencyconverter.service.filesystem.ZipManagerService;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyBusinessImpl implements CurrencyBusiness {

    @Autowired
    ExchangeRecordRepository exchangeRepository;

    @Override
    public void updateCurrencies(List<ExchangeRecord> exchangeRecordList) {
        Field[] fields = ExchangeRecord.class.getFields();

        List<Date> oldDates = exchangeRepository.findAll().stream().map(ExchangeRecord::getDate).toList();
        List<ExchangeRecord> newDates = exchangeRecordList.stream().filter(record ->
                !oldDates.contains(record.getDate())
        ).toList();
        exchangeRepository.saveAll(newDates);
    }
}
