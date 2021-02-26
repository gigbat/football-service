package com.dev.football.dao.impl;

import com.dev.football.dao.FootballHallDao;
import com.dev.football.exception.DataProcessingException;
import com.dev.football.model.FootballHall;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FootballHallDaoImpl implements FootballHallDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public FootballHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public FootballHall add(FootballHall footballHall) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(footballHall);
            transaction.commit();
            return footballHall;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add the football hall " + footballHall, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<FootballHall> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from FootballHall", FootballHall.class)
                    .getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all football hall");
        }
    }

    @Override
    public Optional<FootballHall> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(FootballHall.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Can't get football hall by id " + id, e);
        }
    }
}
