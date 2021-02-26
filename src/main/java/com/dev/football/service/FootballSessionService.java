package com.dev.football.service;

import com.dev.football.model.FootballSession;
import java.time.LocalDate;
import java.util.List;

public interface FootballSessionService {
    List<FootballSession> findAvailableSessions(Long footballId, LocalDate date);

    FootballSession add(FootballSession footballSession);

    void update(FootballSession footballSession);

    void remove(Long id);

    FootballSession get(Long id);
}
