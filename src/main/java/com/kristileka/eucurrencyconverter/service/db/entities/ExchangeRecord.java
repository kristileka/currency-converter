package com.kristileka.eucurrencyconverter.service.db.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "exchange_record")
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "exchange_record", indexes = {@Index(name = "id_index", columnList = "id", unique = true)})
public class ExchangeRecord {
    public ExchangeRecord() {
        super();
    }

    public ExchangeRecord(LocalDate date, String currency, Double amount) {
        this.date = date;
        this.currency = currency;
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "date", columnDefinition = "DATE")
    LocalDate date;

    @Column(name = "currency")
    String currency;

    @Column(name = "amount")
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
