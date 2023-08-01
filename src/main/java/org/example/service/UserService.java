package org.example.service;

import org.example.model.User;
import org.example.repository.IUserDao;
import org.example.repository.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    public void save(User user){
        userDao.save(user);
    }

    public User getById(long id) {
        return userDao.getById(id);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public User getUserBYCredentials(String email, String password) throws Exception {
        return userDao.getUserByCredentials(email, password);
    }
}
