package org.example.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserJDBCDaoImplTest {
    UserJDBCDaoImpl userJDBCDao;

    @Before
    public void setup() {
        userJDBCDao = new UserJDBCDaoImpl();
    }

    @After
    public void teardown() {
        userJDBCDao = null;
    }

    @Test
    public void getUsersTest() {
        assertEquals(0, userJDBCDao.getUsers().size());
    }
}
