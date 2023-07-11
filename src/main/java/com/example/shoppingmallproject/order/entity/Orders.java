package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.share.TimeStamped;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    private Payment payment;

    private Long orderPrice;

    @Builder
    public Orders(User user, Payment payment, Long orderPrice) {
        this.user = user;
        this.payment = payment;
        this.orderPrice = orderPrice;
    }
}
