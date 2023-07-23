package com.example.shoppingmallproject.order.dto;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.orderProduct.entity.OrderStatusEnum;

import lombok.Getter;

@Getter
public class OrderRequestDto {
    private Long id;
    private Long totalPrice;
    private OrderStatusEnum status;

    public OrderRequestDto(Order order){
        this.id = order.getId();
        this.totalPrice = order.getTotalPrice();
        this.status = order.getStatus();
    }
}
