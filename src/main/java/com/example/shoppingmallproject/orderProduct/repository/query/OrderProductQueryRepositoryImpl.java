package com.example.shoppingmallproject.orderProduct.repository.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderProductQueryRepositoryImpl implements OrderProductQueryRepository{
    private final JPAQueryFactory jpaQueryFactory;
}
