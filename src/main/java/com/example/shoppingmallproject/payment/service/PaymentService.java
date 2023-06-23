package com.example.shoppingmallproject.payment.service;

import com.example.shoppingmallproject.payment.dto.PaymentRequestDto;
import org.springframework.transaction.annotation.Transactional;

public interface PaymentService {

    void pay(PaymentRequestDto paymentRequestDto);

    @Transactional
    void pay(PaymentRequestDto paymentRequestDto);
}
