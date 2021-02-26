package com.dev.football.service.impl;

import com.dev.football.dao.ShoppingCartDao;
import com.dev.football.dao.TicketDao;
import com.dev.football.model.FootballSession;
import com.dev.football.model.ShoppingCart;
import com.dev.football.model.Ticket;
import com.dev.football.model.User;
import com.dev.football.service.ShoppingCartService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(FootballSession footballSession, User user) {
        Ticket ticket = new Ticket();
        ticket.setFootballSession(footballSession);
        ticket.setUser(user);
        ticketDao.add(ticket);

        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        shoppingCart.getTicketList().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setTicketList(new ArrayList<>());
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.getTicketList().clear();
        shoppingCartDao.update(shoppingCart);
    }
}
