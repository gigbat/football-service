package com.dev.football.dao;

import com.dev.football.model.Football;
import java.util.List;
import java.util.Optional;

public interface FootballDao {
    Football add(Football football);

    List<Football> getAll();

    Optional<Football> get(Long id);
}
