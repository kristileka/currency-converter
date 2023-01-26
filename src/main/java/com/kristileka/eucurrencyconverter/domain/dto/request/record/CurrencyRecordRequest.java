package com.kristileka.eucurrencyconverter.domain.dto.request.record;

import javax.validation.constraints.NotNull;

public class CurrencyRecordRequest {
    @NotNull(message = "Start Date is required, fieldName: startDate")
    String startDate;
    @NotNull(message = "End Date is required, fieldName: endDate")
    String endDate;
    @NotNull(message = "Currency is required, fieldName: currency")
    String currency;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public CurrencyRecordRequest(String startDate, String endDate, String currency) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.currency = currency;
    }
}
