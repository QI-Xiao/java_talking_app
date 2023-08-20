package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.daoimpl.springdatajpa.UserJPADaoImpl;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Getter
@Setter
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Boolean isRoomChat;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    private MessageType type;

    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userSender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private User userReceiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public Message(MessageType type, User userSender) {
        this.type = type;
        this.userSender = userSender;
    }

//    public User setUserSender(String username) {
//        .
//    }

    public String getUserSender() {
        if (userSender!=null)
            return userSender.getUsername();
        return null;
    }
}
