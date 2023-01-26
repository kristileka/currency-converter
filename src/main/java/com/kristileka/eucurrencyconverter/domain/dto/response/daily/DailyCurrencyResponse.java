package com.kristileka.eucurrencyconverter.domain.dto.response.daily;

import java.time.LocalDate;
import java.util.List;

public class DailyCurrencyResponse {
    private LocalDate date;
    private String baseCurrency;
    private List<DailyCurrencyResponseData> currencyList;

    public DailyCurrencyResponse() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<DailyCurrencyResponseData> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<DailyCurrencyResponseData> currencyList) {
        this.currencyList = currencyList;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }
}
