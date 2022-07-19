package com.kristileka.eucurrencyconverter.cron;

import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;

import java.io.IOException;
import java.util.List;

public interface CurrencyUpdaterService {
    List<ExchangeRecord> updateCurrencies() throws IOException;
}
