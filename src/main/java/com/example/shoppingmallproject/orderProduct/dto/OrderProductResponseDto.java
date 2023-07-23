package com.example.shoppingmallproject.orderProduct.dto;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.entity.OrderStatusEnum;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.seller.entity.Seller;
import com.example.shoppingmallproject.user.dto.UserResponseDto;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderProductResponseDto {

    private Long id;
    private Order order;
    private Product product;
    private Seller seller;
    private Integer quantity;
    private Long totalPrice;
    private OrderStatusEnum orderStatus;

    private OrderProductResponseDto(OrderProduct orderProduct){
        this.id = orderProduct.getId();
        this.orderStatus = orderProduct.getOrderStatus();
        this.order = orderProduct.getOrder();
        this.totalPrice = orderProduct.getTotalPrice();
        this.seller = orderProduct.getSeller();
        this.product = orderProduct.getProduct();
        this.quantity = orderProduct.getQuantity();
    }

    public static OrderProductResponseDto of(OrderProduct orderProduct){
        return new OrderProductResponseDto(orderProduct);
    }
}
