package com.dev.cinema.model.dto;

import javax.validation.constraints.NotNull;

public class MovieSessionRequestDto {
    @NotNull
    private String localDateTime;
    @NotNull
    private Long movieId;
    @NotNull
    private Long cinemaHallId;

    public String getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(String localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
