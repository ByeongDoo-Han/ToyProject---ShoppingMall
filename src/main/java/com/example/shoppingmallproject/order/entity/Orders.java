package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.payment.entity.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
@RequiredArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
//    @Column(name = "ORDER_DATE")
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Column(name = "PAYMENT_ID")
    private BigInteger paymentId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAYMENT_ID")
    private Payment payment;
}
