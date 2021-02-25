package com.dev.football.dao;

import com.dev.football.model.FootballSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FootballSessionDao {
    List<FootballSession> findAvailableSessions(Long footballId, LocalDate date);

    FootballSession add(FootballSession footballSession);

    void update(FootballSession footballSession);

    void remove(Long id);

    Optional<FootballSession> get(Long id);
}
