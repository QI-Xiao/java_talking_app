package org.example.service;

import org.example.entity.User;
import org.example.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Qualifier("UserJPADaoImpl")  // UserHibernateDaoImpl    UserJPADaoImpl
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

    public void delete(Long id) {
        User user = getById(id);
        if (user != null) {
            userDao.delete(user);
        }
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public User getUserBYCredentials(String email, String password) throws Exception {
        return userDao.getUserByCredentials(email, password);
    }
}
