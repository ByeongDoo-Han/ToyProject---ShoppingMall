package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.share.TimeStamped;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
=======

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
    private Payment payment;

    private Long orderPrice;

    @Builder
    public Orders(User user, Payment payment, Long orderPrice) {
        this.user = user;
        this.payment = payment;
        this.orderPrice = orderPrice;
    }
}
