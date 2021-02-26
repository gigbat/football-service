package com.dev.football.service;

import com.dev.football.model.FootballSession;
import com.dev.football.model.ShoppingCart;
import com.dev.football.model.User;

public interface ShoppingCartService {
    void addSession(FootballSession footballSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
