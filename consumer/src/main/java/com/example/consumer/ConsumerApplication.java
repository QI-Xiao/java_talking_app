package com.example.consumer;

import com.example.consumer.service.SQSMessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = {"com.example.consumer"})
public class ConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerApplication.class, args);

//        // easy method
//        ConfigurableApplicationContext app = SpringApplication.run(ConsumerApplication.class, args);
//        SQSMessageService messageService = app.getBean(SQSMessageService.class);
//        messageService.receiveMessage("MyQueue");
    }

}
