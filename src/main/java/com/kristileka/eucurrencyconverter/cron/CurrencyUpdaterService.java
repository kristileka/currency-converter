package com.kristileka.eucurrencyconverter.cron;

import java.io.IOException;

public interface CurrencyUpdaterService {
    Boolean updateCurrencies() throws IOException;
}
