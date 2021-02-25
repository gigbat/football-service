package com.dev.football.service;

import com.dev.football.model.Football;
import java.util.List;

public interface FootballService {
    Football add(Football football);

    List<Football> getAll();

    Football get(Long id);
}
