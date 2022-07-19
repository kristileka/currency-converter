package com.kristileka.eucurrencyconverter.cron;

import java.io.IOException;

public interface CurrencyUpdaterService {
    void updateCurrencies() throws IOException;
}
