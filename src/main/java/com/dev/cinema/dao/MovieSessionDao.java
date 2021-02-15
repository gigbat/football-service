package com.dev.cinema.dao;

import com.dev.cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession sessionMovie);

    void update(MovieSession movieSession);

    void remove(Long id);

    Optional<MovieSession> get(Long id);
}
