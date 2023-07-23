package org.example.service;

import org.example.model.RoomMessage;
import org.example.repository.IRoomMessageDao;
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
