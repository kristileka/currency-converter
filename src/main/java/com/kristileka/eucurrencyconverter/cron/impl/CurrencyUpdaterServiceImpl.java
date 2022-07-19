package com.kristileka.eucurrencyconverter.cron.impl;

import com.kristileka.eucurrencyconverter.cron.CurrencyUpdaterService;
import com.kristileka.eucurrencyconverter.service.filesystem.ZipManagerService;
import com.kristileka.eucurrencyconverter.service.network.NetworkManagerService;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyUpdaterServiceImpl implements CurrencyUpdaterService {

    @Autowired
    ZipManagerService zipManagerService;
    @Autowired
    ExchangeRecordRepository exchangeRepository;
    @Autowired
    NetworkManagerService networkManagerService;

    public void updateCurrencies() {
        networkManagerService.downloadLatestContent();
    }
}
