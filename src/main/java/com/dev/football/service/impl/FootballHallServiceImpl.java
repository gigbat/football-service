package com.dev.football.service.impl;

import com.dev.football.model.FootballHall;
import com.dev.football.service.FootballHallService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballHallServiceImpl implements FootballHallService {
    private final FootballHallService footballHallDao;

    @Autowired
    public FootballHallServiceImpl(FootballHallService footballHallDao) {
        this.footballHallDao = footballHallDao;
    }

    @Override
    public FootballHall add(FootballHall footballHall) {
        return footballHallDao.add(footballHall);
    }

    @Override
    public List<FootballHall> getAll() {
        return footballHallDao.getAll();
    }

    @Override
    public FootballHall get(Long id) {
        return footballHallDao.get(id);
    }
}
