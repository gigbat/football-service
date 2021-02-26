package com.dev.football.service.impl;

import com.dev.football.dao.FootballSessionDao;
import com.dev.football.model.FootballSession;
import com.dev.football.service.FootballSessionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballSessionServiceImpl implements FootballSessionService {
    private final FootballSessionDao footballSessionDao;

    @Autowired
    public FootballSessionServiceImpl(FootballSessionDao footballSessionDao) {
        this.footballSessionDao = footballSessionDao;
    }

    @Override
    public List<FootballSession> findAvailableSessions(Long footballId, LocalDate date) {
        return footballSessionDao.findAvailableSessions(footballId, date);
    }

    @Override
    public FootballSession add(FootballSession footballSession) {
        return footballSessionDao.add(footballSession);
    }

    @Override
    public void update(FootballSession footballSession) {
        footballSessionDao.update(footballSession);
    }

    @Override
    public void remove(Long id) {
        footballSessionDao.remove(id);
    }

    @Override
    public FootballSession get(Long id) {
        return footballSessionDao.get(id).orElseThrow(()
                -> new RuntimeException("Football session by id " + id
                + " wasn't found"));
    }
}
