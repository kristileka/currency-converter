package com.kristileka.eucurrencyconverter.dto.request;

public class CurrencyConverterRequest {
    private String date;
    private String currency;
    private String targetCurrency;
    private Double amount;

    public CurrencyConverterRequest() {
    }

    public CurrencyConverterRequest(String date, String currency, String targetCurrency, Double amount) {
        this.date = date;
        this.currency = currency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
    }

    public String getLocalDate() {
        return date;
    }

    public void setLocalDate(String date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
