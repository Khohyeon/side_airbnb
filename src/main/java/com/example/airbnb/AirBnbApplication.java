package com.example.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirBnbApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirBnbApplication.class, args);
    }

}
