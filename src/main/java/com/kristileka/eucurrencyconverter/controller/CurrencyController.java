package com.kristileka.eucurrencyconverter.controller;

import com.kristileka.eucurrencyconverter.domain.CurrencyDomainService;
import com.kristileka.eucurrencyconverter.dto.request.CurrencyConverterRequest;
import com.kristileka.eucurrencyconverter.dto.response.CurrencyConverterResponse;
import com.kristileka.eucurrencyconverter.dto.response.daily.DailyCurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/")
public class CurrencyController {
    @Autowired
    CurrencyDomainService currencyDomainService;

    @GetMapping("/currency")
    public ResponseEntity<DailyCurrencyResponse> getCurrencyByDate(@RequestParam("date") Optional<String> date ) {
        return ResponseEntity.ok(currencyDomainService.getCurrenciesByDate(date));
    }

    @PostMapping("/currency")
    public ResponseEntity<CurrencyConverterResponse> convertCurrency(@RequestBody CurrencyConverterRequest body) {
        return ResponseEntity.ok(currencyDomainService.convertCurrency(body));
    }
}
