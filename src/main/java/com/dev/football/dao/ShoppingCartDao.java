package com.dev.football.dao;

import com.dev.football.model.ShoppingCart;
import com.dev.football.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    void update(ShoppingCart shoppingCart);
}
