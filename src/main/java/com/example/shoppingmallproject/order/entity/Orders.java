package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.share.TimeStamped;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderPayDelivery> orderPayDelivery;
    private Long orderPrice;

    @Builder
    public Orders(User user, List<OrderPayDelivery> orderPayDelivery, Long orderPrice) {
        this.user = user;
        this.orderPayDelivery = orderPayDelivery;
        this.orderPrice = orderPrice;
    }
}
