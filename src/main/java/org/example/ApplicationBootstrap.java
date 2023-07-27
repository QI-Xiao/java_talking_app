package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = {"org.example"})
@ServletComponentScan(basePackages = {"org.example.filter"})
public class ApplicationBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstrap.class, args);
    }
}
