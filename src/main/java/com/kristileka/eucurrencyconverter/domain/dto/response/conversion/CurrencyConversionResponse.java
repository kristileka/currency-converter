package com.kristileka.eucurrencyconverter.domain.dto.response.conversion;

import java.time.LocalDate;

public class CurrencyConversionResponse {
    private LocalDate date;
    private String currency;
    private String targetCurrency;
    private Double amount;
    private Double convertedAmount;

    public CurrencyConversionResponse() {
    }

    public CurrencyConversionResponse(LocalDate date, String currency, String targetCurrency, Double amount, Double convertedAmount) {
        this.date = date;
        this.currency = currency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate1(LocalDate date) {
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
