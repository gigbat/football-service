package com.dev.football.service.impl;

import com.dev.football.dao.FootballDao;
import com.dev.football.model.Football;
import com.dev.football.service.FootballService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootballServiceImpl implements FootballService {
    private final FootballDao footballDao;

    @Autowired
    public FootballServiceImpl(FootballDao footballDao) {
        this.footballDao = footballDao;
    }

    @Override
    public Football add(Football football) {
        return footballDao.add(football);
    }

    @Override
    public List<Football> getAll() {
        return footballDao.getAll();
    }

    @Override
    public Football get(Long id) {
        return footballDao.get(id).orElseThrow(()
                -> new RuntimeException("Football by id " + id
                + " wasn't found"));
    }
}
