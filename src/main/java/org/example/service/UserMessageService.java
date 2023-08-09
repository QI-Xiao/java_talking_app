package org.example.service;

import org.example.entity.UserMessage;
import org.example.dao.IUserMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageService {
    @Autowired
    private IUserMessageDao userMessageDao;

    public void save(UserMessage userMessage) {
        userMessageDao.save(userMessage);
    }
}
