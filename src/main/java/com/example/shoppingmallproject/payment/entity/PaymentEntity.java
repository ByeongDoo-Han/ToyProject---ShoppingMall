package com.example.shoppingmallproject.payment.entity;

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
@Table
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger paymentId;
    BigInteger totalPrice;
    String payMethod;
    BigInteger payNumber;

    public void setPayMethod(String payMethod){
        this.payMethod = payMethod;
    }

}
