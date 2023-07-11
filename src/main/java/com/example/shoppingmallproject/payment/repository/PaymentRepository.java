package com.example.shoppingmallproject.payment.repository;

import com.example.shoppingmallproject.payment.dto.PaymentsResultDto;
import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.payment.repository.query.PaymentQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PaymentRepository extends JpaRepository<Payment, Long>, PaymentQueryRepository {

}
