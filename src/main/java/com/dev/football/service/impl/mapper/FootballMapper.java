package com.dev.football.service.impl.mapper;

import com.dev.football.model.Football;
import com.dev.football.model.dto.FootballRequestDto;
import com.dev.football.model.dto.FootballResponseDto;
import org.springframework.stereotype.Component;

@Component
public class FootballMapper {
    public Football toEntity(FootballRequestDto footballRequestDto) {
        Football football = new Football();
        football.setTitle(footballRequestDto.getTitle());
        football.setDescription(footballRequestDto.getDescription());
        return football;
    }

    public FootballResponseDto toDto(Football football) {
        FootballResponseDto footballResponseDto = new FootballResponseDto();
        footballResponseDto.setTitle(football.getTitle());
        footballResponseDto.setDescription(football.getDescription());
        return footballResponseDto;
    }
}
