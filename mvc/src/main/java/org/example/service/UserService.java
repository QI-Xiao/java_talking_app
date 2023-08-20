package org.example.service;

import org.example.entity.User;
import org.example.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Qualifier("UserJPADaoImpl")  // UserHibernateDaoImpl    UserJPADaoImpl
    @Autowired
    private IUserDao userDao;

    public User save(User user) throws Exception {
        return userDao.save(user);
    }

    public User getById(long id) {
        return userDao.getById(id);
    }

    public User getByUsername(String username) {return userDao.getByUsername(username);}

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public boolean delete(Long id) {
        User user = getById(id);
        return userDao.delete(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public User getUserBYCredentials(String email, String username, String password) throws Exception {
        return userDao.getUserByCredentials(email, username, password);
    }
}
