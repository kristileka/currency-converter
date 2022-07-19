package com.kristileka.eucurrencyconverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpManagerConfiguration {
    @Bean
    public RestTemplate provideRestTemplate() {
        return new RestTemplate();
    }
}
