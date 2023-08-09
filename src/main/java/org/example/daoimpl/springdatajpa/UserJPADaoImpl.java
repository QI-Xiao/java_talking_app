package org.example.daoimpl.springdatajpa;

import org.example.dao.IUserDao;
import org.example.daoimpl.repository.IUserRepository;
import org.example.entity.User;
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
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User update(User user) {
        return null;
//        return userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public User getUserByCredentials(String email, String password) throws Exception {
        return null;
    }
}
