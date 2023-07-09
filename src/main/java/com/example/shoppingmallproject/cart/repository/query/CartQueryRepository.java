package com.example.shoppingmallproject.cart.repository.query;

import com.example.shoppingmallproject.cart.entity.Cart;

import java.util.List;

public interface CartQueryRepository {
    List<Cart> findCartsByUserId(Long userId);
}
