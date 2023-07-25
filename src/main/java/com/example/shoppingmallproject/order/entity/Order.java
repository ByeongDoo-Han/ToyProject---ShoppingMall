package com.example.shoppingmallproject.order.entity;

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
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false)
    private Long totalPrice;
    @Builder
    public Order(User user, Long totalPrice) {
        this.user = user;
        this.totalPrice = totalPrice;
    }
}
