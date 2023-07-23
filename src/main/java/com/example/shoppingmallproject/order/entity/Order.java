package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.orderProduct.entity.OrderStatusEnum;
import com.example.shoppingmallproject.share.TimeStamped;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Table(name = "ORDERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Column(nullable = false)
    private Long totalPrice;
    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum status;
    @Builder
    public Order(User user, Long totalPrice, Integer quantity) {
        this.user = user;
        this.totalPrice = totalPrice;
        this.status= OrderStatusEnum.PROGRESSING;
        this.quantity = quantity;
    }
}
