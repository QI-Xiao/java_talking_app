package org.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "chatgroups")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String notes;
    @Column
    private Date register_date;
    @Column
    private Date last_active;
}