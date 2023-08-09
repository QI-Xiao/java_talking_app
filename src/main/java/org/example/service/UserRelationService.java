package org.example.service;

import org.example.entity.User;
import org.example.entity.UserRelation;
import org.example.dao.IUserRelationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRelationService {

    @Autowired
    private IUserRelationDao userRelationDao;

    public void save(User user1, User user2) {
        UserRelation userRelation = new UserRelation(user1, user2);
        userRelationDao.save(userRelation);
    }
}
