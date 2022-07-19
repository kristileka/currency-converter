package com.kristileka.eucurrencyconverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfiguration {
    @Bean("extractDirectory")
    public String provideExtractDirectory() {
        return "src/main/resources/extract/";
    }

    @Bean("downloadDirectory")
    public String provideResourceDirectory() {
        return "src/main/resources/download/";
    }

    @Bean("zipName")
    public String provideResourceDirectory() {
        return "currency";
    }

    @Bean("ecbUrl")
    public String provideEcbUrl() {
        return "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist.zip";
    }
}
