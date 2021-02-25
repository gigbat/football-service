package com.dev.football.controller;

import com.dev.football.model.Football;
import com.dev.football.model.dto.FootballRequestDto;
import com.dev.football.model.dto.FootballResponseDto;
import com.dev.football.service.FootballService;
import com.dev.football.service.impl.mapper.FootballMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-matches")
public class FootballController {
    private final FootballService footballService;
    private final FootballMapper footballMapper;

    @Autowired
    public FootballController(FootballService footballService, FootballMapper footballMapper) {
        this.footballService = footballService;
        this.footballMapper = footballMapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid FootballRequestDto footballRequestDto) {
        footballService.add(footballMapper.toEntity(footballRequestDto));
    }

    @GetMapping
    public List<FootballResponseDto> getAll() {
        List<Football> footballs = footballService.getAll();
        return footballs.stream()
                .map(footballMapper::toDto)
                .collect(Collectors.toList());
    }
}
