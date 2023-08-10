package org.example.daoimpl.hibernate;

import org.example.dao.IUserDao;
import org.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJDBCDaoImpl implements IUserDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5430/talking_db";
    static final String USER = "admin";
    static final String PASS = "Training123!";

    @Override
    public List<User> getUsers() {
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.debug("start getUser()");

        List<User> userList = new ArrayList<>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            int numberOfTries = 0;
            while (conn == null & numberOfTries < 3) {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                numberOfTries += 1;
            }

            statement = conn.createStatement();
            String sql = "SELECT * FROM users";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            logger.error("unable to connect to db", e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                logger.error("unable to close db connection", e);
            }
        }
        logger.info("finish getUsers {}", userList);
        return userList;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public User getUserByCredentials(String email, String username, String password) throws Exception {
        return null;
    }
}
