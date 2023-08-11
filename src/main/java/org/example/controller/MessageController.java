package org.example.controller;

import org.example.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @MessageMapping("/server")
    @SendTo("/subscriber/oneuser")
    public Message publishMessage(Message message) throws Exception {
        logger.info("message - ======================================== \"{}\"", message);
        message.setMessage(HtmlUtils.htmlEscape(message.getMessage()));
        return message;
    }
}
