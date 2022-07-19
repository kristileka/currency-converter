package com.kristileka.eucurrencyconverter.service.network.impl;

import com.kristileka.eucurrencyconverter.service.network.NetworkManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class NetworkManagerServiceImpl implements NetworkManagerService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    String ecbUrl;

    @Autowired
    String downloadDirectory;

    @Override
    public void downloadLatestContent() {
        byte[] content = restTemplate.getForObject(ecbUrl, byte[].class);
        if (content == null) return;
        File directory = new File(downloadDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
        try (FileOutputStream stream = new FileOutputStream("src/main/resources/download/currency-data.zip")) {
            stream.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
