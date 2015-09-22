package com.rusamaha.gm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.rusamaha.gm")
public class GmApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmApplication.class, args);
    }

}
