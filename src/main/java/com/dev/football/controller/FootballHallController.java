package com.dev.football.controller;

import com.dev.football.model.FootballHall;
import com.dev.football.model.dto.FootballHallRequestDto;
import com.dev.football.model.dto.FootballHallResponseDto;
import com.dev.football.service.FootballHallService;
import com.dev.football.service.impl.mapper.FootballHallMapper;
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
@RequestMapping("/stadiums")
public class FootballHallController {
    private final FootballHallService footballHallService;
    private final FootballHallMapper footballHallMapper;

    @Autowired
    public FootballHallController(FootballHallService footballHallService,
                                FootballHallMapper footballHallMapper) {
        this.footballHallService = footballHallService;
        this.footballHallMapper = footballHallMapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid FootballHallRequestDto footballHallRequestDto) {
        footballHallService.add(footballHallMapper.toEntity(footballHallRequestDto));
    }

    @GetMapping
    public List<FootballHallResponseDto> getAll() {
        List<FootballHall> footballHalls = footballHallService.getAll();
        return footballHalls.stream()
                .map(footballHallMapper::toDto)
                .collect(Collectors.toList());
    }
}
