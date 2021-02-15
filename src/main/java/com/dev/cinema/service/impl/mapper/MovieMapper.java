package com.dev.cinema.service.impl.mapper;

import com.dev.cinema.model.Movie;
import com.dev.cinema.model.dto.MovieRequestDto;
import com.dev.cinema.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie toEntity(MovieRequestDto movieRequestDto) {
        Movie movie = new Movie();
        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        return movie;
    }

    public MovieResponseDto toDto(Movie movie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        movieResponseDto.setTitle(movie.getTitle());
        movieResponseDto.setDescription(movie.getDescription());
        return movieResponseDto;
    }
}
