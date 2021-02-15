package com.dev.cinema.service.impl.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.MovieSessionRequestDto;
import com.dev.cinema.model.dto.MovieSessionResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private final CinemaHallService cinemaHallService;
    private final MovieService movieService;

    @Autowired
    public MovieSessionMapper(CinemaHallService cinemaHallService, MovieService movieService) {
        this.cinemaHallService = cinemaHallService;
        this.movieService = movieService;
    }

    public MovieSession toEntity(MovieSessionRequestDto movieSessionRequestDto) {
        MovieSession movieSession = new MovieSession();
        movieSession.setMovie(movieService.get(movieSessionRequestDto.getMovieId()));
        movieSession.setCinemaHall(cinemaHallService.get(movieSessionRequestDto
                .getCinemaHallId()));
        LocalDateTime localDateTime = LocalDateTime.parse(movieSessionRequestDto
                .getLocalDateTime(), DateTimeFormatter.ISO_DATE_TIME);
        movieSession.setLocalDate(localDateTime);
        return movieSession;
    }

    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto dto = new MovieSessionResponseDto();
        dto.setMovieId(movieSession.getMovie().getId());
        dto.setMovieTitle(movieSession.getMovie().getTitle());
        dto.setMovieSessionId(movieSession.getId());
        dto.setCinemaHallId(movieSession.getCinemaHall().getId());
        dto.setLocalDateTime(movieSession.getLocalDateTime().toString());
        return dto;
    }
}
