package com.kristileka.eucurrencyconverter.domain.dto.response.average;

public class CurrencyAverageResponse {
    String currency;
    Double averageRate;
    String baseCurrency = "EUR";
    String startDate;
    String endDate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public CurrencyAverageResponse(String currency, Double averageRate, String startDate, String endDate) {
        this.currency = currency;
        this.averageRate = averageRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
