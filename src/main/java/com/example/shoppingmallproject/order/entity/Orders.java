package com.example.shoppingmallproject.order.entity;

import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
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

    @Builder
    public Orders(Long userId, Long paymentId, Payment payment) {
        this.userId = userId;
        this.paymentId = paymentId;
        this.payment = payment;
    }
}
