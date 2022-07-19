package com.kristileka.eucurrencyconverter.service.filesystem;

import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface ZipManagerService {
    void unZipFile(String file, String destination) throws IOException;
}
