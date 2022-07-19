package com.kristileka.eucurrencyconverter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency")
public class CurrencyController {
    @GetMapping("/get")
    public ResponseEntity<String> getCurrency() {
        return ResponseEntity.ok("Hehe");
    }
}
