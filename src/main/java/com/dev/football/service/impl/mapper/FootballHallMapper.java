package com.dev.football.service.impl.mapper;

import com.dev.football.model.FootballHall;
import com.dev.football.model.dto.FootballHallRequestDto;
import com.dev.football.model.dto.FootballHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class FootballHallMapper {
    public FootballHall toEntity(FootballHallRequestDto footballHallRequestDto) {
        FootballHall footballHall = new FootballHall();
        footballHall.setCapacity(footballHallRequestDto.getCapacity());
        footballHall.setDescription(footballHallRequestDto.getDescription());
        return footballHall;
    }

    public FootballHallResponseDto toDto(FootballHall footballHall) {
        FootballHallResponseDto footballHallResponseDto = new FootballHallResponseDto();
        footballHallResponseDto.setCapacity(footballHall.getCapacity());
        footballHallResponseDto.setDescription(footballHall.getDescription());
        return footballHallResponseDto;
    }
}
