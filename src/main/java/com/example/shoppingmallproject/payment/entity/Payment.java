package com.example.shoppingmallproject.payment.entity;

import com.example.shoppingmallproject.order.entity.Orders;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Getter
@Table(name = "PAYMENT")
public class Payment extends TimeStamped {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private Long id;
    @Column(name = "TOTAL_PRICE")
    private Long totalPrice;
    @Column(name = "PAY_METHOD")
    private String payMethod;
    @Column(name = "PAY_NUMBER")
    private Long payNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
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
