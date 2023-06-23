package com.example.shoppingmallproject.payment.repository;

import com.example.shoppingmallproject.payment.entity.PaymentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void createPayment(){
        //given
        final PaymentEntity payment = PaymentEntity.builder()
            .paymentId(BigInteger.valueOf(1))
            .payNumber(BigInteger.valueOf(1000))
            .payMethod("카드")
            .build();

        //when
        final PaymentEntity result = paymentRepository.save(payment);

        //then
        assertThat(result.getPaymentId()).isEqualTo(1);
        assertThat(result.getPayMethod()).isEqualTo("카드");
        assertThat(result.getPayNumber()).isEqualTo(1000);
    }
}