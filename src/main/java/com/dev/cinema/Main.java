package com.dev.cinema;

import com.dev.cinema.exception.AuthenticationException;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    private static Injector injector = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) throws AuthenticationException {
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

        LocalDateTime localDateTime = LocalDateTime.of(2021, 1, 31, 10, 0);

        MovieSession movieSession = new MovieSession();
        movieSession.setLocalDate(localDateTime);
        movieSession.setMovie(movie2);
        movieSession.setCinemaHall(cinemaHall);

        MovieSession movieSession1 = new MovieSession();
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 1, 30,15, 0);
        movieSession1.setLocalDate(localDateTime1);
        movieSession1.setMovie(movie);
        movieSession1.setCinemaHall(cinemaHall1);

        MovieSession movieSession2 = new MovieSession();
        LocalDateTime localDateTime2 = LocalDateTime.of(2021, 2, 1, 20, 0);
        movieSession2.setLocalDate(localDateTime2);
        movieSession2.setMovie(movie1);
        movieSession2.setCinemaHall(cinemaHall);

        MovieSession movieSession3 = new MovieSession();
        movieSession3.setLocalDate(localDateTime);
        movieSession3.setMovie(movie2);
        movieSession3.setCinemaHall(cinemaHall);

        MovieSession movieSession4 = new MovieSession();
        movieSession4.setLocalDate(localDateTime);
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
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<MovieSession> availableSessions = movieSessionService
                .findAvailableSessions(3L, LocalDate
                        .parse(dateTimeFormatter.format(localDateTime)));
        availableSessions.forEach(System.out::println);

        System.out.println("===========================================");
        AuthenticationService authenticationService = (AuthenticationService) injector
                .getInstance(AuthenticationService.class);

        String log = "123";
        String pwd = "hello";
        authenticationService.register(log, pwd);

        String log1 = "321";
        String pwd1 = "goodbye";
        authenticationService.register(log1, pwd1);

        String log2 = "1010";
        String pwd2 = "qweasddfge";
        authenticationService.register(log2, pwd2);

        System.out.println("============================================");
        User user = authenticationService.login(log1, pwd1);
        ShoppingCartService shoppingCartService = (ShoppingCartService) injector
                .getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(movieSession, user);
        shoppingCartService.addSession(movieSession1, user);
        shoppingCartService.addSession(movieSession2, user);
        shoppingCartService.addSession(movieSession3, user);
        System.out.println(shoppingCartService.getByUser(user));
        ShoppingCart cart = shoppingCartService.getByUser(user);
        shoppingCartService.clear(cart);
        System.out.println(shoppingCartService.getByUser(user));
    }
}
