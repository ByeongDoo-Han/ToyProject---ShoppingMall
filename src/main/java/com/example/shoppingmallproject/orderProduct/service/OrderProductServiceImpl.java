package com.example.shoppingmallproject.orderProduct.service;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductRequestDto;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductResponseDto;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.entity.OrderStatusEnum;
import com.example.shoppingmallproject.orderProduct.repository.OrderProductRepository;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService{
    private final OrderProductRepository orderProductRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public OrderProduct createOneOrderProduct(Order order, Product product) {
        OrderProduct orderProduct = OrderProduct.builder()
            .orderStatus(order.getStatus())
            .order(order)
            .product(product)
            .seller(product.getSeller())
            .quantity(order.getQuantity())
            .totalPrice(order.getTotalPrice())
            .build();
        orderProductRepository.save(orderProduct);
        return orderProduct;
    }
}
