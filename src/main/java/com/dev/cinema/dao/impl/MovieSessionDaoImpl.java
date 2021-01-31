package com.dev.cinema.dao.impl;

import com.dev.cinema.dao.MovieSessionDao;
import com.dev.cinema.lib.Dao;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieSessionDaoImpl implements MovieSessionDao {
    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<MovieSession> query = session
                    .createQuery("select ms from MovieSession ms inner join ms.movie m "
                                    + "where m.id = :id and ms.localDate = :date",
                            MovieSession.class);
            query.setParameter("id", movieId);
            query.setParameter("date", date);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't find available sessions by movie id "
                    + movieId + " and by movie date " + date.toString(), e);
        }
    }

    @Override
    public MovieSession add(MovieSession sessionMovie) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
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
