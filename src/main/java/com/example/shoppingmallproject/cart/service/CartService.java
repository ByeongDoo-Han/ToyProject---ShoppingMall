package com.example.shoppingmallproject.cart.service;

import com.example.shoppingmallproject.cart.dto.CartRequestDto;
import com.example.shoppingmallproject.cart.dto.CartsWithProductsDto;
import com.example.shoppingmallproject.user.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartService {

    @Transactional
    List<CartsWithProductsDto> getCartsWithProducts(Long userId);

    @Transactional
    void createCart(CartRequestDto dto, User user);
}
