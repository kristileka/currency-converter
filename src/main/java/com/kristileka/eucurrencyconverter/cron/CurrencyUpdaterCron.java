package com.kristileka.eucurrencyconverter.cron;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CurrencyUpdaterCron implements SmartLifecycle {

    @Autowired
    CurrencyUpdaterService currencyUpdaterBusiness;
    Logger logger = LoggerFactory.getLogger(CurrencyUpdaterCron.class);
    private boolean running = false;

    @Scheduled(fixedDelay = 10 * 1000L)
    public void startCurrencyUpdater() {
        try {
            currencyUpdaterBusiness.updateCurrencies();
        } catch (IOException ignored) {
            logger.error("ERROR => Currencies are not updating.");
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
