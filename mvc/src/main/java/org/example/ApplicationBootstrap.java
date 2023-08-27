package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"org.example"})
//@ServletComponentScan(basePackages = {"org.example.filter"})
public class ApplicationBootstrap extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationBootstrap.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootstrap.class, args);

        logger.trace("======= BankCompanyApplication, this is a trace level logger info from {}", "Cliff");
        logger.debug("======= BankCompanyApplication, this is a debug level logger info from {}", "Cliff");
        logger.info("======= BankCompanyApplication, this is a info level logger info from {}", "Cliff");
        logger.warn("======= BankCompanyApplication, this is a warn level logger info from {}", "Cliff");
        logger.error("======= BankCompanyApplication, this is a error level logger info from {}", "Cliff");
    }
}
