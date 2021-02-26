package com.dev.football.model.dto;

import javax.validation.constraints.NotNull;

public class FootballSessionRequestDto {
    @NotNull
    private String localDateTime;
    @NotNull
    private Long footballId;
    @NotNull
    private Long footballHallId;

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getFootballId() {
        return footballId;
    }

    public void setFootballId(Long footballId) {
        this.footballId = footballId;
    }

    public Long getFootballHallId() {
        return footballHallId;
    }

    public void setFootballHallId(Long footballHallId) {
        this.footballHallId = footballHallId;
    }
}
