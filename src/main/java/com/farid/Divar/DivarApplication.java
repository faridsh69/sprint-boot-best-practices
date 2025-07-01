package com.farid.Divar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.farid.Divar.Configs")
public class DivarApplication {
	public static void main(String[] args) {
		SpringApplication.run(DivarApplication.class, args);
	}
}
