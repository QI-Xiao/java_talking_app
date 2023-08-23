package com.example.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProcessService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @JmsListener(destination = "MyQueue")
    public void processMessage(String msg) throws IOException {
        System.out.println(msg);

//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map = new HashMap<>();
//        // convert JSON string to Map
//        map = mapper.readValue(msg, new TypeReference<Map<String, String>>(){});
//        String msgType = (String)map.get("id");
//        String msgText = (String)map.get("domainName");
//        Long userID = Long.valueOf(msgText);
//        logger.info("receive msgType: "+msgType);
//        logger.info("receive msgText: "+msgText);
    }
}
