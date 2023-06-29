package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Entity
@Table(name = "ORDERS")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Orders extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "ORDER_DATE")
    @Column(name = "USER_ID")
    private Long userId;
    @JoinColumn(name = "PAYMENT_ID")
    private Long paymentId;
    @OneToOne(fetch = FetchType.LAZY)
    private Payment payment;
}
