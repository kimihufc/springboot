package com.hjl.produce.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: HJL
 * @create: 2018-12-13 10:18
 */
@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties
public class TestConfig {

    private String name;

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
            "name='" + name + '\'' +
            ", path='" + path + '\'' +
            '}';
    }
}
