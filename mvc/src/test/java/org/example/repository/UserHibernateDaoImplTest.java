package org.example.repository;

import org.example.daoimpl.hibernate.UserHibernateDaoImpl;
import org.example.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserHibernateDaoImplTest {

    private UserHibernateDaoImpl userHibernateDao;

    private User user;

    @BeforeEach
    public void setUp() {
        userHibernateDao = new UserHibernateDaoImpl();
        user = new User();
        user.setId(2);
        user.setUsername("a");
        user.setAddress("aaa");
        user.setEmail("aaa");
        user.setFirst_name("aaa");
        user.setLast_name("aaa");
        user.setProfile("aaa");
        user.setLast_active(new java.sql.Date(119, 6, 18));
        user.setRegister_date(new java.sql.Date(119, 6, 18));
        userHibernateDao.save(user);
    }

    @AfterEach
    public void tearDown() {
//        userHibernateDao.delete(user);
    }

    @Test
    public void getUsersTest(){
        assertEquals(1, userHibernateDao.getUsers().size());
    }
}
