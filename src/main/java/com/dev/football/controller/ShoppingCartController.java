package com.dev.football.controller;

import com.dev.football.model.FootballSession;
import com.dev.football.model.ShoppingCart;
import com.dev.football.model.User;
import com.dev.football.model.dto.ShoppingCartResponseDto;
import com.dev.football.service.FootballSessionService;
import com.dev.football.service.ShoppingCartService;
import com.dev.football.service.UserService;
import com.dev.football.service.impl.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final FootballSessionService footballSessionService;
    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  FootballSessionService footballSessionService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.footballSessionService = footballSessionService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @PostMapping("/football-sessions")
    public void addSession(Authentication authentication,
                           @RequestParam Long footballSessionId) {
        String email = authentication.getName();
        User user = userService.findByEmail(email).get();
        FootballSession footballSession = footballSessionService.get(footballSessionId);
        shoppingCartService.addSession(footballSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        String email = authentication.getName();
        User user = userService.findByEmail(email).get();
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartMapper.toDto(shoppingCart);
    }
}
