package com.example.shoppingmallproject.orderProduct.entity;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.seller.entity.Seller;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProduct extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Long totalPrice;
    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum orderStatus;
}
