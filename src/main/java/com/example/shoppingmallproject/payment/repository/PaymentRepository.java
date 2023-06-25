package com.example.shoppingmallproject.payment.repository;

import com.example.shoppingmallproject.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, BigInteger> {
}
