package com.dev.football.dao;

import com.dev.football.model.FootballHall;
import java.util.List;
import java.util.Optional;

public interface FootballHallDao {
    FootballHall add(FootballHall cinemaHall);

    List<FootballHall> getAll();

    Optional<FootballHall> get(Long id);
}
