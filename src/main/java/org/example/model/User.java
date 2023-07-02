package org.example.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String nickname;
    @Column
    private String first_name;
    @Column
    private String last_name;
    @Column
    private String profile;
    @Column
    private String email;
    @Column
    private String address;
    @Column
    private Date register_date;
    @Column
    private Date last_active;

    public void setId(long id) {
        this.id = id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public void setLast_active(Date last_active) {
        this.last_active = last_active;
    }
}
