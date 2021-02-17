package com.dev.cinema.service.impl.mapper;

import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.dto.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();
        shoppingCartResponseDto.setShoppingCartId(shoppingCart.getId());
        shoppingCartResponseDto.setUserEmail(shoppingCart.getUser().getEmail());
        return shoppingCartResponseDto;
    }
}
