package com.kristileka.eucurrencyconverter.cron;

import com.kristileka.eucurrencyconverter.service.redis.ExchangeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CurrencyUpdaterCron implements SmartLifecycle {

    private boolean running = false;

    @Autowired
    CurrencyUpdaterService currencyUpdaterBusiness;

    @Scheduled(fixedDelay = 10 * 1000L)
    public void startCurrencyUpdater() {
        try {
            currencyUpdaterBusiness.updateCurrencies();
        } catch (IOException ex) {

        }
    }

    @Override
    public void start() {
        startCurrencyUpdater();
    }

    @Override
    public void stop() {
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
