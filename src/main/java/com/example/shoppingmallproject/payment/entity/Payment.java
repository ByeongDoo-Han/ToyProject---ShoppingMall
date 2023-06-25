package com.example.shoppingmallproject.payment.entity;

import com.example.shoppingmallproject.order.entity.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    private BigInteger id;
    @Column(name = "TOTAL_PRICE")
    private BigInteger totalPrice;
    @Column(name = "PAY_METHOD")
    private String payMethod;
    @Column(name = "PAY_NUMBER")
    private BigInteger payNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "PAYMENT")
    private Orders order;

    private void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }

}
