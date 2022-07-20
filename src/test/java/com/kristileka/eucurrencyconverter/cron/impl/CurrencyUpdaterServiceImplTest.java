package com.kristileka.eucurrencyconverter.cron.impl;

import com.kristileka.eucurrencyconverter.domain.CurrencyDomainService;
import com.kristileka.eucurrencyconverter.service.filesystem.CsvManagerService;
import com.kristileka.eucurrencyconverter.service.filesystem.ZipManagerService;
import com.kristileka.eucurrencyconverter.service.network.NetworkManagerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyUpdaterServiceImplTest {

    private final ZipManagerService zipManagerService = Mockito.mock(ZipManagerService.class);
    private final NetworkManagerService networkManagerService = Mockito.mock(NetworkManagerService.class);
    private final CsvManagerService csvManagerService = Mockito.mock(CsvManagerService.class);
    private final CurrencyDomainService currencyDomainService = Mockito.mock(CurrencyDomainService.class);

    @Test
    void updateCurrenciesNetworkFail() throws IOException {
        CurrencyUpdaterServiceImpl currencyUpdaterService = new CurrencyUpdaterServiceImpl(zipManagerService, networkManagerService, csvManagerService, currencyDomainService);
        Mockito.when(networkManagerService.getLatestContent()).thenReturn(
                ""
        );
        boolean response = currencyUpdaterService.updateCurrencies();
        assertFalse(response);
    }
    @Test
    void updateCurrenciesNetworkSuccess() throws IOException {
        CurrencyUpdaterServiceImpl currencyUpdaterService = new CurrencyUpdaterServiceImpl(zipManagerService, networkManagerService, csvManagerService, currencyDomainService);
        Mockito.when(networkManagerService.getLatestContent()).thenReturn(
                "Testased"
        );
        boolean response = currencyUpdaterService.updateCurrencies();
        assertTrue(response);
    }
}