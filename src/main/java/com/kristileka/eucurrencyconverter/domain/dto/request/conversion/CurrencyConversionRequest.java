package com.kristileka.eucurrencyconverter.domain.dto.request.conversion;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CurrencyConversionRequest {


    @NotNull(message = "Date is required, fieldName: date")
    private String date;
    @NotNull(message = "Currency is required, fieldName: currency")
    private String currency;
    @NotNull(message = "Target Currency is required, fieldName: targetCurrency")
    private String targetCurrency;
    @NotNull(message = "Amount is required, fieldName: amount")
    @Min(value = 1, message = "Amount must be greater than 0")
    private Double amount;

    public CurrencyConversionRequest() {
    }

    public CurrencyConversionRequest(String date, String currency, String targetCurrency, Double amount) {
        this.date = date;
        this.currency = currency;
        this.targetCurrency = targetCurrency;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
