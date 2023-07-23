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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserHibernateDaoImpl implements IUserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserHibernateDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        logger.info("Start getUsers from postgres via hibernate");

        List<User> userList = new ArrayList<>();

        Session session = sessionFactory.openSession();
        try {
            String hql = "from User";
            Query<User> query = session.createQuery(hql);

            userList = query.list();

            session.close();
        } catch (HibernateException e) {
            logger.error("Open session error", e);
            session.close();
        }

        logger.info("Get user {}", userList);
        return userList;
    }

    @Override
    public void save(User user) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            if (transaction != null) {
                logger.error("Rollback create");
                transaction.rollback();
            }
            logger.error("create error", e);
            session.close();
        }
    }

    @Override
    public void delete(User user) {
        Transaction tx = null;
        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.delete(user);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                logger.error("Delete error", e);
                tx.rollback();
            }
            logger.error("delete er");
        }
    }

    @Override
    public User update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            User u = getById(user.getId());
            session.close();
            return u;
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("failed", e);
            session.close();
            return null;
        }
    }

    @Override
    public User getById(long id) {
        Session session = sessionFactory.openSession();
        String hql = "FROM User u where id= :Id";

        try {
            Query<User> query = session.createQuery(hql);
            query.setParameter("Id", id);
            User result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("Session exception", e);
            session.close();
            return null;
        }
    }
}
