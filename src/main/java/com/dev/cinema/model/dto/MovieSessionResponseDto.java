package com.dev.cinema.model.dto;

public class MovieSessionResponseDto {
    private String movieTitle;
    private String localDateTime;
    private Long movieId;
    private Long cinemaHallId;
    private Long movieSessionId;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

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

    public void setMovieSessionId(Long id) {
        this.movieSessionId = id;
    }

    public Long getMovieSessionId() {
        return movieSessionId;
    }
}
