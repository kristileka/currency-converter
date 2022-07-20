package com.kristileka.eucurrencyconverter.domain.impl;

import com.kristileka.eucurrencyconverter.domain.CurrencyDomainService;
import com.kristileka.eucurrencyconverter.dto.ExchangeRecordDTO;
import com.kristileka.eucurrencyconverter.dto.request.CurrencyConverterRequest;
import com.kristileka.eucurrencyconverter.dto.response.CurrencyConverterResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.exceptions.CustomException;
import com.kristileka.eucurrencyconverter.exceptions.ExceptionType;
import com.kristileka.eucurrencyconverter.mappers.CurrencyServiceMapper;
import com.kristileka.eucurrencyconverter.service.db.CurrencyManualRepository;
import com.kristileka.eucurrencyconverter.service.db.ExchangeRecordRepository;
import com.kristileka.eucurrencyconverter.service.db.entities.ExchangeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.kristileka.eucurrencyconverter.extensions.Extensions.validateDates;

@Service
public class CurrencyDomainServiceImpl implements CurrencyDomainService {

    @Autowired
    ExchangeRecordRepository exchangeRecordRepository;

    @Autowired
    CurrencyManualRepository currencyManualRepository;

    @Autowired
    CurrencyServiceMapper currencyServiceMapper;

    @Override
    public void updateCurrencies(List<ExchangeRecordDTO> exchangeRecordList) {
        List<String> storedDatesCurrencies = exchangeRecordRepository.findAll().stream().parallel().map(exchangeRecord -> exchangeRecord.getDate() + exchangeRecord.getCurrency()).toList();
        if (storedDatesCurrencies.size() == exchangeRecordList.size()) {
            return;
        }
        List<ExchangeRecordDTO> toUpdate = exchangeRecordList.stream().parallel().filter(exchangeRecord -> !storedDatesCurrencies.contains(exchangeRecord.getDate() + exchangeRecord.getCurrency())).toList();
        List<ExchangeRecord> exchangeRecords = toUpdate.stream().parallel().map(record -> new ExchangeRecord(record.getDate(), record.getCurrency(), record.getAmount())).toList();
        currencyManualRepository.saveAll(exchangeRecords);
    }

    @Override
    public DailyCurrencyResponse getCurrenciesByDate(Optional<String> date) {
        LocalDate localDate;
        if (date.isPresent()) {
            validateDates(date.get());
            localDate = LocalDate.parse(date.get());
        } else {
            localDate = LocalDate.now();
        }
        List<ExchangeRecord> selectedDateRecords = exchangeRecordRepository.findAllByDate(localDate);
        if (selectedDateRecords.isEmpty()) {
            throw new CustomException(ExceptionType.DATE_NOT_FOUND);
        }
        return currencyServiceMapper.mapDailyCurrencyResponse(localDate, selectedDateRecords);
    }

    @Override
    public CurrencyConverterResponse convertCurrency(CurrencyConverterRequest body) {
        validateDates(body.getLocalDate());
        ExchangeRecord baseCurrency = exchangeRecordRepository.findByDateAndCurrency(LocalDate.parse(body.getLocalDate()), body.getCurrency());
        ExchangeRecord targetCurrency = exchangeRecordRepository.findByDateAndCurrency(LocalDate.parse(body.getLocalDate()), body.getTargetCurrency());
        if (baseCurrency == null || targetCurrency == null)
            throw new CustomException(ExceptionType.CURRENCY_OR_DATE_NOT_FOUND);
        Double convertedAmount = (body.getAmount() / baseCurrency.getAmount()) * targetCurrency.getAmount();
        return currencyServiceMapper.mapConvertedCurrency(body, convertedAmount);
    }


}
