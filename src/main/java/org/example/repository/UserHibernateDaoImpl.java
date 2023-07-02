package org.example.repository;

import org.example.model.User;
import org.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserHibernateDaoImpl implements IUserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserHibernateDaoImpl.class);

    @Override
    public List<User> getUsers() {
        logger.info("Start getUsers from postgres via hibernate");

        List<User> userList = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            Session session = sessionFactory.openSession();

            String hql = "from User";
            Query<User> query = session.createQuery(hql);

            userList = query.list();

            session.close();
        } catch (HibernateException e) {
            logger.error("Open session error", e);
        }

        logger.info("Get user {}", userList);
        return userList;
    }

    @Override
    public void save(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            Session session = sessionFactory.openSession();
            session.save(user);
            session.close();
        } catch (HibernateException e) {
            logger.error("Create error", e);
        }
    }

//    public static void main(String[] args) {
//        User user = new User();
//        user.setId(2);
//        user.setNickname("bbb");
//        user.setAddress("aaa");
//        user.setEmail("aaa");
//        user.setFirst_name("aaa");
//        user.setLast_name("aaa");
//        user.setProfile("aaa");
//        user.setLast_active(new java.sql.Date(119, 6, 18));
//        user.setRegister_date(new java.sql.Date(119, 6, 18));
//        UserHibernateDaoImpl userHibernateDao = new UserHibernateDaoImpl();
//        userHibernateDao.save(user);
//    }

    @Override
    public void delete(User user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.delete(user);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            logger.error("Delete error", e);
        }
    }
}
