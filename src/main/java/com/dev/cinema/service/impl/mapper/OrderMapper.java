package com.dev.cinema.service.impl.mapper;

import com.dev.cinema.model.Order;
import com.dev.cinema.model.dto.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setTickets(order.getTickets());
        orderResponseDto.setUser(order.getUser());
        return orderResponseDto;
    }
}
