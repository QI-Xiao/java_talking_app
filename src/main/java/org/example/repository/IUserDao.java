package org.example.repository;

import org.example.model.User;

import java.util.List;

public interface IUserDao {

    List<User> getUsers();

    void save(User user);

    void delete(User user);
}
