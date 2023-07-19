package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import com.example.shoppingmallproject.share.TimeStamped;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private Long totalPrice;

    @Builder
    public Order(User user, Long totalPrice) {
        this.user = user;
        this.totalPrice = totalPrice;

}
