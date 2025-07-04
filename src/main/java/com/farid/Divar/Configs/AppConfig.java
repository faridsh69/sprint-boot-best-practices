package com.farid.Divar.Configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

// Usage of application.properties as object
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class AppConfig {
    private String name;
}
