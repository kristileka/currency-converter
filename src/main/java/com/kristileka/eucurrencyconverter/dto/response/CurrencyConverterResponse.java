package com.kristileka.eucurrencyconverter.dto.response;

import java.time.LocalDate;

public class CurrencyConverterResponse {
    private LocalDate localDate;
    private String currency;
    private String targetCurrency;
    private Double amount;
    private Double convertedAmount;

    public CurrencyConverterResponse() {
    }

    public CurrencyConverterResponse(LocalDate localDate, String currency, String targetCurrency, Double amount, Double convertedAmount) {
        this.localDate = localDate;
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
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
