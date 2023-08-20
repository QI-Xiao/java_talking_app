package org.example.service;

import org.example.entity.Room;
import org.example.dao.IRoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private IRoomDao roomDao;

    public void save(Room room) {
        roomDao.save(room);
    }
}
