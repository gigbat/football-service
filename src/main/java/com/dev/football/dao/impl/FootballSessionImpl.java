package com.dev.football.dao.impl;

import com.dev.football.dao.FootballSessionDao;
import com.dev.football.exception.DataProcessingException;
import com.dev.football.model.FootballSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FootballSessionImpl implements FootballSessionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public FootballSessionImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<FootballSession> findAvailableSessions(Long footballId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<FootballSession> query = session
                    .createQuery("select ms from FootballSession ms inner join ms.football m "
                                    + "where m.id = :id "
                                    + "and date_format(ms.localDateTime, '%Y-%m-%d') = :date",
                            FootballSession.class);
            query.setParameter("id", footballId);
            query.setParameter("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available sessions by football id "
                    + footballId + " and by football date " + date.toString(), e);
        }
    }

    @Override
    public FootballSession add(FootballSession footballSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(footballSession);
            transaction.commit();
            return footballSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add the football session " + footballSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(FootballSession footballSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(footballSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't update the football session " + footballSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            FootballSession footballSession = session.load(FootballSession.class, id);
            session.remove(footballSession);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't remove the football session by id " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<FootballSession> get(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return Optional.ofNullable(session.get(FootballSession.class, id));
        } catch (Exception e) {
            throw new RuntimeException("Can't get football by id " + id, e);
        }
    }
}
