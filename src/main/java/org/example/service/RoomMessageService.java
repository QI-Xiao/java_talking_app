package org.example.service;

import org.example.entity.RoomMessage;
import org.example.dao.IRoomMessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomMessageService {
    @Autowired
    private IRoomMessageDao roomMessageDao;

    public void save(RoomMessage roomMessage) {
        roomMessageDao.save(roomMessage);
    }
}
