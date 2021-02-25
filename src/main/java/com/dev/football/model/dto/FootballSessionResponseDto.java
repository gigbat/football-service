package com.dev.football.model.dto;

public class FootballSessionResponseDto {
    private String footballTitle;
    private String localDateTime;
    private Long footballId;
    private Long footballHallId;
    private Long footballSessionId;

    public String getFootballTitle() {
        return footballTitle;
    }

    public void setFootballTitle(String footballTitle) {
        this.footballTitle = footballTitle;
    }

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

    public void setFootballSessionId(Long id) {
        this.footballSessionId = id;
    }

    public Long getFootballSessionId() {
        return footballSessionId;
    }
}
