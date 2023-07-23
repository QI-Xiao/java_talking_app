package org.example.repository;

import org.example.model.UserMessage;

public interface IUserMessageDao {
    void save(UserMessage userMessage);
}
