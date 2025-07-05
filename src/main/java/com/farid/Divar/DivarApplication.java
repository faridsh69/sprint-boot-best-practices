package com.farid.Divar;

import com.farid.Divar.Commands.UserSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan("com.farid.Divar.Configs")
public class DivarApplication {
    public static void main(String[] args) {
        SpringApplication.run(DivarApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(UserSeeder userSeeder) {
        return args -> {
            userSeeder.seed();
        };
    }
}
