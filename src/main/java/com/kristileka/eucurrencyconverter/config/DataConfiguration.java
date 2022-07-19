package com.kristileka.eucurrencyconverter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class DataConfiguration {


    @Bean("downloadDirectoryPath")
    public String provideDownloadDirectoryPath() {
        return "src/main/resources/download/";
    }

    @Bean("zipFileName")
    public String provideZipFileName() {
        return "eurofxref-hist.zip";
    }

    @Bean("csvFileName")
    public String provideCsvFileNameName() {
        return "eurofxref-hist.csv";
    }

    @Bean("extractDirectoryPath")
    public String provideExtractDirectoryPath() {
        return "src/main/resources/extract/";
    }

    @Bean("ecbUrl")
    public String provideEcbUrl() {
        return "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-hist.zip";
    }
}
