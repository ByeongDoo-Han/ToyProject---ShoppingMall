package com.example.shoppingmallproject.payment.repository.query;

import com.example.shoppingmallproject.payment.entity.Payment;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.shoppingmallproject.payment.entity.QPayment.payment;
import static com.example.shoppingmallproject.orderPayDelivery.entity.QOrderPayDelivery.orderPayDelivery;
@Repository
@RequiredArgsConstructor
public class PaymentQueryRepositoryImpl implements PaymentQueryRepository{
    private final JPAQueryFactory jpaQueryFactory;

//    @Override
//    public List<PaymentsResultDto> findPaymentsByUserId(Long userId) {
//        return null;
//    }
    @Override
    public List<Payment> findPaymentsByUserId(Long userId){
        return jpaQueryFactory
            .selectFrom(payment)
            .where(orderPayDelivery.order.user.id.eq(userId))
            .fetch();
    }
}
