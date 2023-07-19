package com.example.shoppingmallproject.payment.entity;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import com.example.shoppingmallproject.share.TimeStamped;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


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

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderPayDelivery> orderPayDelivery;

    @ManyToOne(fetch = FetchType.LAZY)
    private User users;

    private void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }

    @Builder
    public Payment(Long totalPrice, String payMethod, Long payNumber, List<OrderPayDelivery> orderPayDelivery) {
        this.totalPrice = totalPrice;
        this.payMethod = payMethod;
        this.payNumber = payNumber;
        this.orderPayDelivery = orderPayDelivery;
    }
}
