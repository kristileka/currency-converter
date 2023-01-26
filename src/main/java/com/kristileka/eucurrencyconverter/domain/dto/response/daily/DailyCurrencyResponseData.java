package com.kristileka.eucurrencyconverter.domain.dto.response.daily;

public class DailyCurrencyResponseData {
    private String currency;
    private Double amount;

    public DailyCurrencyResponseData(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public DailyCurrencyResponseData() {
    }

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
}
