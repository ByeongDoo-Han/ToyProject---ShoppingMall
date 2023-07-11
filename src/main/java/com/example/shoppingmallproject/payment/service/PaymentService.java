package com.example.shoppingmallproject.payment.service;

import com.example.shoppingmallproject.payment.dto.PaymentRequestDto;
import com.example.shoppingmallproject.payment.dto.PaymentsResultDto;
import com.example.shoppingmallproject.user.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentService {

    @Transactional
    void pay(PaymentRequestDto paymentRequestDto);

    @Transactional
    List<PaymentsResultDto> getPayments(User user);
}
