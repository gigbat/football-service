package com.dev.football.service.impl.mapper;

import com.dev.football.model.FootballSession;
import com.dev.football.model.dto.FootballSessionRequestDto;
import com.dev.football.model.dto.FootballSessionResponseDto;
import com.dev.football.service.FootballHallService;
import com.dev.football.service.FootballService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FootballSessionMapper {
    private final FootballHallService footballHallService;
    private final FootballService footballService;

    @Autowired
    public FootballSessionMapper(FootballHallService footballHallService,
                                 FootballService footballService) {
        this.footballHallService = footballHallService;
        this.footballService = footballService;
    }

    public FootballSession toEntity(FootballSessionRequestDto footballSessionRequestDto) {
        FootballSession footballSession = new FootballSession();
        footballSession.setFootball(footballService.get(footballSessionRequestDto.getFootballId()));
        footballSession.setFootballHall(footballHallService.get(footballSessionRequestDto
                .getFootballHallId()));
        LocalDateTime localDateTime = LocalDateTime.parse(footballSessionRequestDto
                .getLocalDateTime(), DateTimeFormatter.ISO_DATE_TIME);
        footballSession.setLocalDate(localDateTime);
        return footballSession;
    }

    public FootballSessionResponseDto toDto(FootballSession footballSession) {
        FootballSessionResponseDto dto = new FootballSessionResponseDto();
        dto.setFootballId(footballSession.getFootball().getId());
        dto.setFootballTitle(footballSession.getFootball().getTitle());
        dto.setFootballSessionId(footballSession.getId());
        dto.setFootballHallId(footballSession.getFootballHall().getId());
        dto.setLocalDateTime(footballSession.getLocalDateTime().toString());
        return dto;
    }
}
