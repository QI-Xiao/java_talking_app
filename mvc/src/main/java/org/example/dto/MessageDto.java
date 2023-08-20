package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.entity.Message;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@ToString
@Getter
@Setter
//@Builder
public class MessageDto {
    private String content;

    private String userSender;

//    private User user;

    public MessageDto(String userSender, MessageType type) {
        this.userSender = userSender;
        this.type = type;
    }

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    private MessageType type;

//    @Autowired
//    UserService userService;
//
//    public void setUser(String username) {
//
//        this.user = userService.getByUsername(username);
//    }
}
