package com.dev.football.controller;

import com.dev.football.model.FootballSession;
import com.dev.football.model.dto.FootballSessionRequestDto;
import com.dev.football.model.dto.FootballSessionResponseDto;
import com.dev.football.service.FootballSessionService;
import com.dev.football.service.impl.mapper.FootballSessionMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-sessions")
public class FootballSessionController {
    private final FootballSessionService footballSessionService;
    private final FootballSessionMapper footballSessionMapper;

    @Autowired
    public FootballSessionController(FootballSessionService footballSessionService,
                                  FootballSessionMapper footballSessionMapper) {
        this.footballSessionService = footballSessionService;
        this.footballSessionMapper = footballSessionMapper;
    }

    @PostMapping
    public void create(@RequestBody @Valid FootballSessionRequestDto footballSessionRequestDto) {
        footballSessionService.add(footballSessionMapper.toEntity(footballSessionRequestDto));
    }

    @GetMapping("/available")
    public List<FootballSessionResponseDto> findAvailableSessions(
            @RequestParam Long footballId, @RequestParam @DateTimeFormat(pattern =
                    "yyyy-MM-dd") LocalDate date) {
        List<FootballSession> availableSessions = footballSessionService
                .findAvailableSessions(footballId, date);
        return availableSessions.stream()
                .map(footballSessionMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody FootballSessionRequestDto footballSessionRequestDto) {
        FootballSession footballSession = footballSessionMapper.toEntity(footballSessionRequestDto);
        footballSession.setId(id);
        footballSessionService.update(footballSession);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        footballSessionService.remove(id);
    }
}
