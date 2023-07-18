package com.example.shoppingmallproject.payment.service;

import com.example.shoppingmallproject.cart.dto.CartRequestDto;
import com.example.shoppingmallproject.cart.entity.Cart;
import com.example.shoppingmallproject.payment.dto.PaymentRequestDto;
import com.example.shoppingmallproject.payment.dto.PaymentsResultDto;
import com.example.shoppingmallproject.payment.entity.Payment;
import com.example.shoppingmallproject.payment.repository.PaymentRepository;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional(readOnly = true)
    public void pay(PaymentRequestDto paymentRequestDto) {
        String payMethod = paymentRequestDto.getPayMethod();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentsResultDto> getPayments(User user) {
        Long userId = user.getId();
        List<Payment> list = paymentRepository.findPaymentsByUserId(userId);
        return list.stream()
            .map( m-> PaymentsResultDto.builder()
                .id(m.getId())
                .payNumber(m.getPayNumber())
                .totalPrice(m.getTotalPrice())
                .payMethod(m.getPayMethod())
                .build()).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentsResultDto> doCartsPayments(User user) {
        Long userId = user.getId();

        return null;
    }
}
