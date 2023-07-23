package com.example.shoppingmallproject.order.service;


import com.example.shoppingmallproject.common.security.userDetails.entity.UserDetailsImpl;
import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.user.entity.User;

public interface OrderService {

    Order createOneOrder(Long productId, User user, Integer quantity);
}
