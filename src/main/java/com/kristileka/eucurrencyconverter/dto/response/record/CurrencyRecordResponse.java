package com.kristileka.eucurrencyconverter.dto.response.record;

public class CurrencyRecordResponse {
    String currency;
    Double amount;
    String baseCurrency = "EUR";
    String startDate;
    String endDate;
    String recordDate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public CurrencyRecordResponse(String currency, Double amount, String startDate, String endDate, String recordDate) {
        this.currency = currency;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.recordDate = recordDate;
    }
}
