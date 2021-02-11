package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.exception.DataProcessingException;
import com.dev.cinema.model.MovieSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> query = session
                    .createQuery("select ms from MovieSession ms inner join ms.movie m "
                                    + "where m.id = :id "
                                    + "and date_format(ms.localDateTime, '%Y-%m-%d') = :date",
                            MovieSession.class);
            query.setParameter("id", movieId);
            query.setParameter("date", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
            return query.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find available sessions by movie id "
                    + movieId + " and by movie date " + date.toString(), e);
        }
    }

    @Override
    public MovieSession add(MovieSession sessionMovie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(sessionMovie);
            transaction.commit();
            return sessionMovie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add the movie session " + sessionMovie, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
