package org.example.repository;

import org.example.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomHibernateDaoImpl implements IRoomDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void save(Room room) {
        Transaction transaction = null;
        Session session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(room);
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
}
