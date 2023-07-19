package com.example.shoppingmallproject.orderPayDelivery.entity;

import com.example.shoppingmallproject.delivery.entity.Delivery;
import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderPayDelivery extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    private Payment payment;
    @ManyToOne(fetch = FetchType.LAZY)
    private Delivery delivery;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @Builder
    public OrderPayDelivery(Order order, Payment payment, Delivery delivery, Product product) {
        this.order = order;
        this.payment = payment;
        this.delivery = delivery;
        this.product = product;
    }
}
