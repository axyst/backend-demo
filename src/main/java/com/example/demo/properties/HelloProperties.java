package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private String tempvar;

    public void setTempvar(String tempvar) {
        this.tempvar = tempvar;
    }

    public String getTempvar() {
        return tempvar;
    }
}
