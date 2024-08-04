package com.rota.cemrota.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "arquivo")
public class FileStoragePropPontoInt {
    private String upfileDir;

    public String getUpfileDir() {
        return upfileDir;
    }

    public void setUpfileDir(String upfileDir) {
        this.upfileDir = upfileDir;
    }

}
