package com.kristileka.eucurrencyconverter.service.network.impl;

import com.kristileka.eucurrencyconverter.service.network.NetworkManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class NetworkManagerServiceImpl implements NetworkManagerService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    String ecbUrl;
    @Autowired
    String downloadDirectoryPath;
    @Autowired
    String zipFileName;


    @Override
    public String getLatestContent() {
        byte[] content = restTemplate.getForObject(ecbUrl, byte[].class);
        if (content == null) return "";
        File directory = new File(downloadDirectoryPath);
        if (!directory.exists())
            directory.mkdir();
        String fileLocation = downloadDirectoryPath + zipFileName;
        try (FileOutputStream stream = new FileOutputStream(fileLocation)) {
            stream.write(content);
        } catch (IOException e) {
            return "";
        }
        return fileLocation;
    }
}
