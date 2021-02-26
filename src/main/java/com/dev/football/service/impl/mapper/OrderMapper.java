package com.dev.football.service.impl.mapper;

import com.dev.football.model.Order;
import com.dev.football.model.Ticket;
import com.dev.football.model.dto.OrderResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        List<Ticket> tickets = order.getTickets();
        List<Long> ticketsId = new ArrayList<>();
        for (Ticket ticket : tickets) {
            ticketsId.add(ticket.getId());
        }
        orderResponseDto.setTicketsId(ticketsId);
        orderResponseDto.setEmail(order.getUser().getEmail());
        return orderResponseDto;
    }
}
