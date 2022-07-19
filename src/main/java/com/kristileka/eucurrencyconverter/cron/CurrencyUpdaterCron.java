package com.kristileka.eucurrencyconverter.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CurrencyUpdaterCron implements SmartLifecycle {

    private boolean running = false;

    @Autowired
    CurrencyUpdaterService currencyUpdaterBusiness;

    @Scheduled(fixedDelay = 10 * 1000L)
    public void startCurrencyUpdater() {
        currencyUpdaterBusiness.updateCurrencies();
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
