package org.example.daoimpl.springdatajpa;

import org.example.dao.IUserDao;
import org.example.daoimpl.repository.IUserRepository;
import org.example.entity.User;
import org.example.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserJPADaoImpl")
public class UserJPADaoImpl implements IUserDao {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) throws Exception {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new Exception("Email already exists");
        }
        if (userRepository.findByUsername(user.getUsername()) != null)
            throw new Exception("Username already exists");

        User new_user;
        try {
            new_user = userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }

        return new_user;
    }

    @Override
    public boolean delete(User user) {
        if (user!=null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByCredentials(String email, String username, String password) throws Exception {

        User user = userRepository.findByEmailAndPassword(email, password);
        if (user!=null)
            return user;

        user = userRepository.findByUsernameAndPassword(username, password);
        if (user!=null)
            return user;

        throw new UserNotFoundException("can't find user record with email or username");
    }
}
