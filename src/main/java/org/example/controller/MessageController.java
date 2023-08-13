package org.example.controller;

import org.example.dto.MessageDto;
import org.example.entity.Message;
import org.example.entity.User;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public MessageDto publishMessage(MessageDto message) throws Exception {
        logger.info("message - ======================================== \"{}\"", message);
//        message.setMessage(HtmlUtils.htmlEscape(message.getMessage()));
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public MessageDto addUser(User user, SimpMessageHeaderAccessor headerAccessor) {
        logger.info("User - {}", user);
        logger.info("SimpMessageHeaderAccessor - {}", headerAccessor);
        user = userService.getByUsername(user.getUsername());
        headerAccessor.getSessionAttributes().put("username", user.getUsername());
        MessageDto mes = new MessageDto(user.getUsername(), MessageDto.MessageType.JOIN);
        logger.info("message - {}", mes);
        return mes;
    }
}
