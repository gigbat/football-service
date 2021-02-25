package com.dev.football.dao;

import com.dev.football.model.Order;
import com.dev.football.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
