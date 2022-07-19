package com.kristileka.eucurrencyconverter.core.impl;

import com.kristileka.eucurrencyconverter.core.CurrencyBusiness;
import com.kristileka.eucurrencyconverter.service.filesystem.ZipManagerService;
import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyBusinessImpl implements CurrencyBusiness {

    @Autowired
    ZipManagerService zipManagerService;
    @Autowired
    ExchangeRecordRepository exchangeRepository;

}
