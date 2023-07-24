//package com.example.shoppingmallproject.payment.repository;
//
//import com.example.shoppingmallproject.payment.entity.Payment;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class PaymentRepositoryTest {
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Test
//    public void createPayment(){
//        //given
//        final Payment payment = Payment.builder()
//            .payNumber(Long.valueOf(1000))
//            .payMethod("카드")
//            .build();
//
//        //when
//        final Payment result = paymentRepository.save(payment);
//
//        //then
//        assertThat(result.getId()).isEqualTo(1);
//        assertThat(result.getPayMethod()).isEqualTo("카드");
//        assertThat(result.getPayNumber()).isEqualTo(1000);
//    }
//}