package com.kristileka.eucurrencyconverter.cron.impl;

import com.kristileka.eucurrencyconverter.domain.CurrencyDomainService;
import com.kristileka.eucurrencyconverter.cron.CurrencyUpdaterService;
import com.kristileka.eucurrencyconverter.dto.CurrencyRecordDTO;
import com.kristileka.eucurrencyconverter.service.filesystem.CsvManagerService;
import com.kristileka.eucurrencyconverter.service.filesystem.ZipManagerService;
import com.kristileka.eucurrencyconverter.service.network.NetworkManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CurrencyUpdaterServiceImpl implements CurrencyUpdaterService {

    @Autowired
    public CurrencyUpdaterServiceImpl(ZipManagerService zipManagerService, NetworkManagerService networkManagerService, CsvManagerService csvManagerService, CurrencyDomainService currencyDomainService) {
        this.zipManagerService = zipManagerService;
        this.networkManagerService = networkManagerService;
        this.csvManagerService = csvManagerService;
        this.currencyDomainService = currencyDomainService;
    }

    private final ZipManagerService zipManagerService;
    private final NetworkManagerService networkManagerService;
    private final CsvManagerService csvManagerService;
    private final CurrencyDomainService currencyDomainService;

    @Override
    public Boolean updateCurrencies() throws IOException {
        String latestContentZip = networkManagerService.getLatestContent();
        if (latestContentZip.isEmpty())
            return false;
        String csvPath = zipManagerService.unZipFile(latestContentZip);
        List<CurrencyRecordDTO> currencyRecordDTOList = csvManagerService.readCsvCurrencyRecords(csvPath);
        currencyDomainService.updateCurrencies(currencyRecordDTOList);
        return true;
    }
}
