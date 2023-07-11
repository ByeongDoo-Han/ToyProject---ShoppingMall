package com.example.shoppingmallproject.cart.repository.query;

import com.example.shoppingmallproject.cart.entity.Cart;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.shoppingmallproject.cart.entity.QCart.cart;


@Repository
@RequiredArgsConstructor
public class CartQueryRepositoryImpl implements CartQueryRepository {
    /**
     * @RequiredArgsConstructer 어노테이션을 활용해서 final 필드 생성자 주입 (QueryDSL 사용을 위함)
     */
    private final JPAQueryFactory queryFactory;

    /**
     *
     * @param userId 패러미터로 userId 가 들어오면, 해당 유저를 특정해서
     * @return 그 유저가 가진 Carts 를 리턴합니다.
     */
    @Override
    public List<Cart> findCartsByUserId(Long userId) {
        return queryFactory
                .selectFrom(cart) // static import 해준 상태입니다. 해당 cart 는 Q 객체에요!
                .where(cart.user.id.eq(userId))
                .fetch();
    }

    // QueryDSL 예시를 주기 위해 만든 매서드


}
