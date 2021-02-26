package com.dev.football.service;

import com.dev.football.model.FootballHall;
import java.util.List;

public interface FootballHallService {
    FootballHall add(FootballHall footballHall);

    List<FootballHall> getAll();

    FootballHall get(Long id);
}
