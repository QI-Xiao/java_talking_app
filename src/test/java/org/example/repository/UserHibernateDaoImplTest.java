package org.example.repository;

import org.example.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class UserHibernateDaoImplTest {

    private UserHibernateDaoImpl userHibernateDao;

    private User user;

    @Before
    public void setUp() {
        userHibernateDao = new UserHibernateDaoImpl();
        user = new User();
        user.setId(2);
        user.setNickname("a");
        user.setAddress("aaa");
        user.setEmail("aaa");
        user.setFirst_name("aaa");
        user.setLast_name("aaa");
        user.setProfile("aaa");
        user.setLast_active(new java.sql.Date(119, 6, 18));
        user.setRegister_date(new java.sql.Date(119, 6, 18));
        userHibernateDao.save(user);
    }

    @After
    public void tearDown() {
//        userHibernateDao.delete(user);
    }

    @Test
    public void getUsersTest(){
        assertEquals(1, userHibernateDao.getUsers().size());
    }
}
