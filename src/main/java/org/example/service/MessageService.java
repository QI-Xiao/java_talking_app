package org.example.service;

import org.example.entity.Message;
import org.example.dao.IMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private IMessageDao userMessageDao;

    public void save(Message message) {
        userMessageDao.save(message);
    }
}
