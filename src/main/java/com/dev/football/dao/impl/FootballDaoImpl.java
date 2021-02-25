package com.dev.football.dao.impl;

import com.dev.football.dao.FootballDao;
import com.dev.football.exception.DataProcessingException;
import com.dev.football.model.Football;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FootballDaoImpl implements FootballDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public FootballDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Football add(Football football) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(football);
            transaction.commit();
            return football;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert football entity " + football, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Football> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Football> queryAllFootballs = session.createQuery("from Football",
                    Football.class);
            return queryAllFootballs.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all footballs", e);
        }
    }

    @Override
    public Optional<Football> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(Football.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Can't get football by id " + id, e);
        }
    }
}
