package com.kristileka.eucurrencyconverter.service.redis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.time.LocalDate;

@RedisHash("exchange-record")
public class ExchangeRecord {
    public ExchangeRecord(String id, LocalDate date, String currency, Double amount) {
        this.id = id;
        this.date = date;
        this.currency = currency;
        this.amount = amount;
    }


    @JsonIgnore
    @Id
    String id;
    @Indexed

    LocalDate date;
    @Indexed
    String currency;
    Double amount;


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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
