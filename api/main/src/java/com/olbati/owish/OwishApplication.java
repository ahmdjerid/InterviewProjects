package com.olbati.owish;

import com.olbati.owish.config.OwishConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(OwishConfiguration.class)
@SpringBootApplication
public class OwishApplication {

    public static void main(String[] args) {
        SpringApplication.run(OwishApplication.class, args);
    }
}
