package com.example.shoppingmallproject.payment.entity;

import com.example.shoppingmallproject.order.entity.Orders;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long totalPrice;

    @Column(nullable = false)
    private String payMethod;

    @Column(nullable = false)
    private Long payNumber;

    @OneToOne(mappedBy = "payment")
    private Orders order;

    private void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }

    @Builder
    public Payment(Long totalPrice, String payMethod, Long payNumber, Orders order) {
        this.totalPrice = totalPrice;
        this.payMethod = payMethod;
        this.payNumber = payNumber;
        this.order = order;
    }
}
