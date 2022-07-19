package com.kristileka.eucurrencyconverter.service.filesystem;

import java.io.IOException;

public interface ZipManagerService {
    String unZipFile(String path) throws IOException;
}
