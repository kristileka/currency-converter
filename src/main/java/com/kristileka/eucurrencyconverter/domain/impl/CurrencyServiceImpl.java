package com.kristileka.eucurrencyconverter.domain.impl;

import com.kristileka.eucurrencyconverter.config.exceptions.CustomException;
import com.kristileka.eucurrencyconverter.config.exceptions.ExceptionType;
import com.kristileka.eucurrencyconverter.domain.dto.CurrencyRecordDTO;
import com.kristileka.eucurrencyconverter.domain.dto.request.average.CurrencyAverageRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.conversion.CurrencyConversionRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.record.CurrencyRecordRequest;
import com.kristileka.eucurrencyconverter.domain.dto.response.average.CurrencyAverageResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.conversion.CurrencyConversionResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.record.CurrencyRecordResponse;
import com.kristileka.eucurrencyconverter.domain.mappers.CurrencyServiceMapper;
import com.kristileka.eucurrencyconverter.service.db.CurrencyManualRepository;
import com.kristileka.eucurrencyconverter.service.db.CurrencyRepository;
import com.kristileka.eucurrencyconverter.service.db.entities.CurrencyRecord;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kristileka.eucurrencyconverter.domain.CurrencyService;

import static com.kristileka.eucurrencyconverter.extensions.Extensions.validateDates;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyManualRepository currencyManualRepository;
    private final CurrencyServiceMapper currencyServiceMapper;

    @Autowired
    CurrencyServiceImpl(CurrencyServiceMapper currencyServiceMapper, CurrencyManualRepository currencyManualRepository, CurrencyRepository currencyRepository) {
        this.currencyServiceMapper = currencyServiceMapper;
        this.currencyManualRepository = currencyManualRepository;
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Boolean updateCurrencies(List<CurrencyRecordDTO> currencyRecordDTOList) {
        List<String> storedDatesCurrencies = currencyRepository.findAll().stream().parallel().map(currencyRecord -> currencyRecord.getDate() + currencyRecord.getCurrency()).toList();
        if (storedDatesCurrencies.size() == currencyRecordDTOList.size()) {
            return false;
        }
        List<CurrencyRecordDTO> toUpdate = currencyRecordDTOList.stream().parallel().filter(currencyRecordDTO -> !storedDatesCurrencies.contains(currencyRecordDTO.getDate() + currencyRecordDTO.getCurrency())).toList();
        List<CurrencyRecord> currencyRecords = toUpdate.stream().parallel().map(record -> new CurrencyRecord(record.getDate(), record.getCurrency(), record.getAmount())).toList();
        currencyManualRepository.saveAll(currencyRecords);
        return true;
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
        List<CurrencyRecord> selectedDateRecords = currencyRepository.findAllByDate(localDate);
        if (selectedDateRecords.isEmpty()) {
            throw new CustomException(ExceptionType.DATE_NOT_FOUND);
        }
        return currencyServiceMapper.mapDailyCurrencyResponse(localDate, selectedDateRecords);
    }

    @Override
    public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest body) {
        validateDates(body.getDate());
        CurrencyRecord baseCurrency;
        CurrencyRecord targetCurrency;
        if (!body.getCurrency().equalsIgnoreCase("EUR"))
            baseCurrency = currencyRepository.findByDateAndCurrency(LocalDate.parse(body.getDate()), body.getCurrency());
        else baseCurrency = new CurrencyRecord(LocalDate.now(), "EUR", 1.0);

        if (!body.getTargetCurrency().equalsIgnoreCase("EUR"))
            targetCurrency = currencyRepository.findByDateAndCurrency(LocalDate.parse(body.getDate()), body.getTargetCurrency());
        else targetCurrency = new CurrencyRecord(LocalDate.now(), "EUR", 1.0);

        if (baseCurrency == null || targetCurrency == null)
            throw new CustomException(ExceptionType.CURRENCY_OR_DATE_NOT_FOUND);
        Double convertedAmount = (body.getAmount() / baseCurrency.getAmount()) * targetCurrency.getAmount();
        return currencyServiceMapper.mapConvertedCurrency(body, convertedAmount);
    }

    @Override
    public CurrencyRecordResponse getCurrencyRecord(CurrencyRecordRequest body) {
        validateDates(body.getStartDate(), body.getEndDate());
        CurrencyRecord bestRecord = currencyRepository.findRecordRate(body.getCurrency(), LocalDate.parse(body.getStartDate()), LocalDate.parse(body.getEndDate()));
        if (bestRecord == null) throw new CustomException(ExceptionType.CURRENCY_OR_DATE_NOT_FOUND);
        return currencyServiceMapper.mapBestRecord(bestRecord, body);
    }

    @Override
    public CurrencyAverageResponse getCurrencyAverage(CurrencyAverageRequest body) {
        validateDates(body.getStartDate(), body.getEndDate());
        Double averageRate = currencyRepository.findAverageRate(body.getCurrency(), LocalDate.parse(body.getStartDate()), LocalDate.parse(body.getEndDate()));
        if (averageRate == null) throw new CustomException(ExceptionType.CURRENCY_OR_DATE_NOT_FOUND);
        return currencyServiceMapper.mapAverageRate(averageRate, body);
    }


}
