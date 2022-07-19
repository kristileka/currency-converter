package com.kristileka.eucurrencyconverter.dto;

import java.time.LocalDate;

public class ExchangeRecordDTO {
    public ExchangeRecordDTO(LocalDate date, String currency, double amount) {
        this.date = date;
        this.currency = currency;
        this.amount = amount;
    }


    LocalDate date;
    String currency;
    double amount;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}