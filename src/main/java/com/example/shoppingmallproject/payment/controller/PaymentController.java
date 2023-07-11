package com.example.shoppingmallproject.payment.controller;

import com.example.shoppingmallproject.payment.dto.PaymentsResultDto;
import com.example.shoppingmallproject.payment.service.PaymentService;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/payments")
    public List<PaymentsResultDto> getPayments(@AuthenticationPrincipal User user){
        return paymentService.getPayments(user);
    }
}
