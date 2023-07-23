package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "user_messages")
public class UserMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_relation_id")
    private UserRelation userRelation;

    @Column
    private Boolean is_use1_send;
}
