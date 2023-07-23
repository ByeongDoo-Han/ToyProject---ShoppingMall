package com.example.shoppingmallproject.order.service;

import com.example.shoppingmallproject.common.security.userDetails.entity.UserDetailsImpl;
import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.order.repository.OrderRepository;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.ProductRepository;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    @Override
    @Transactional
    public Order createOneOrder(Long productId, User user, Integer quantity) {
        Product product = productRepository.getProductById(productId);
        Order order = Order.builder()
            .totalPrice(product.getPrice())
            .user(user)
            .quantity(quantity)
            .build();
        orderRepository.save(order);
        return order;
    }
}
