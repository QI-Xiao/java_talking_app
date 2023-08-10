package org.example.dao;

import org.example.entity.User;

import java.util.List;

public interface IUserDao {

    List<User> getUsers();

    User save(User user);

    boolean delete(User user);

    User update(User user);

    User getById(long id);

    User getUserByCredentials(String email, String username, String password) throws Exception;
}
