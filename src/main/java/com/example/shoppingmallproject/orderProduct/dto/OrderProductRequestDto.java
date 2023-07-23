package com.example.shoppingmallproject.orderProduct.dto;

import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.entity.OrderStatusEnum;
import lombok.Getter;

@Getter
public class OrderProductRequestDto {
    private Long id;
    private Long orderId;
    private Long productId;
    private Long sellerId;
    private Integer quantity;
    private Long productPrice;
    private OrderStatusEnum status;

    public OrderProductRequestDto(OrderProduct orderProduct){
        this.id = orderProduct.getId();
        this.orderId = orderProduct.getOrder().getId();
        this.productId = orderProduct.getProduct().getId();
        this.sellerId = orderProduct.getSeller().getId();
        this.quantity = orderProduct.getQuantity();
        this.productPrice = orderProduct.getTotalPrice();
        this.status = orderProduct.getOrderStatus();
    }


}
