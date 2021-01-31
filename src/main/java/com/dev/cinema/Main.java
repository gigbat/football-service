package com.dev.cinema;

import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setTitle("Fast and Furious");
        movie.setDescription("the best film");

        Movie movie1 = new Movie();
        movie1.setTitle("It");
        movie1.setDescription("About a terrible clown");

        Movie movie2 = new Movie();
        movie2.setTitle("The last ship");
        movie2.setDescription("About epidemic");

        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        movieService.add(movie);
        movieService.add(movie1);
        movieService.add(movie2);
        movieService.getAll().forEach(System.out::println);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(100);

        CinemaHall cinemaHall1 = new CinemaHall();
        cinemaHall1.setCapacity(200);

        CinemaHall cinemaHall2 = new CinemaHall();
        cinemaHall2.setCapacity(150);

        CinemaHallService cinemaHallService = (CinemaHallService) injector
                .getInstance(CinemaHallService.class);
        cinemaHallService.add(cinemaHall);
        cinemaHallService.add(cinemaHall1);
        cinemaHallService.add(cinemaHall2);
        cinemaHallService.getAll().forEach(System.out::println);

        LocalDate localDate = LocalDate.of(2021, 1, 31);

        MovieSession movieSession = new MovieSession();
        movieSession.setLocalDate(localDate);
        movieSession.setMovie(movie2);
        movieSession.setCinemaHall(cinemaHall);

        MovieSession movieSession1 = new MovieSession();
        LocalDate localDate1 = LocalDate.of(2021, 1, 30);
        movieSession1.setLocalDate(localDate1);
        movieSession1.setMovie(movie);
        movieSession1.setCinemaHall(cinemaHall1);

        MovieSession movieSession2 = new MovieSession();
        LocalDate localDate2 = LocalDate.of(2021, 2, 1);
        movieSession2.setLocalDate(localDate2);
        movieSession2.setMovie(movie1);
        movieSession2.setCinemaHall(cinemaHall);

        MovieSession movieSession3 = new MovieSession();
        movieSession3.setLocalDate(localDate);
        movieSession3.setMovie(movie2);
        movieSession3.setCinemaHall(cinemaHall);

        MovieSession movieSession4 = new MovieSession();
        movieSession4.setLocalDate(localDate);
        movieSession4.setMovie(movie2);
        movieSession4.setCinemaHall(cinemaHall1);

        MovieSessionService movieSessionService = (MovieSessionService) injector
                .getInstance(MovieSessionService.class);
        System.out.println(movieSessionService.add(movieSession));
        System.out.println(movieSessionService.add(movieSession1));
        System.out.println(movieSessionService.add(movieSession2));
        System.out.println(movieSessionService.add(movieSession3));
        System.out.println(movieSessionService.add(movieSession4));
        System.out.println("==========================================");
        List<MovieSession> availableSessions = movieSessionService
                .findAvailableSessions(3L, localDate);
        availableSessions.forEach(System.out::println);
    }
}
