package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "user1", cascade = CascadeType.DETACH)
    @JsonIgnore
    private Set<UserRelation> user1Relations;

    @OneToMany(mappedBy = "user2", cascade = CascadeType.DETACH)
    @JsonIgnore
    private Set<UserRelation> user2Relations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Set<RoomMessage> roomMessages;

    @ManyToMany
    @JoinTable(name = "users_rooms", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "room_id")})
    @JsonIgnore
    private List<Room> rooms;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public Date getLast_active() {
        return last_active;
    }

    public void setLast_active(Date last_active) {
        this.last_active = last_active;
    }

    public Set<UserRelation> getUser1Relations() {
        return user1Relations;
    }

    public void setUser1Relations(Set<UserRelation> user1Relations) {
        this.user1Relations = user1Relations;
    }

    public Set<UserRelation> getUser2Relations() {
        return user2Relations;
    }

    public void setUser2Relations(Set<UserRelation> user2Relations) {
        this.user2Relations = user2Relations;
    }

    public Set<RoomMessage> getRoomMessages() {
        return roomMessages;
    }

    public void setRoomMessages(Set<RoomMessage> roomMessages) {
        this.roomMessages = roomMessages;
    }

//    public List<Room> getRooms() {
//        return rooms;
//    }
//
//    public void setRooms(List<Room> rooms) {
//        this.rooms = rooms;
//    }
}
