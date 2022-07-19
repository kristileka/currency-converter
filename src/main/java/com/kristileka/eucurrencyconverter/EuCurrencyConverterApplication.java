package com.kristileka.eucurrencyconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EuCurrencyConverterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EuCurrencyConverterApplication.class, args);
    }
}
