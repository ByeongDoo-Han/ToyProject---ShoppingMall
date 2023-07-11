package com.example.shoppingmallproject.cart.repository.query;

import com.example.shoppingmallproject.cart.entity.Cart;
<<<<<<< HEAD
=======
import com.example.shoppingmallproject.product.entity.QProduct;
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7

import static com.example.shoppingmallproject.cart.entity.QCart.cart;


@Repository
@RequiredArgsConstructor
public class CartQueryRepositoryImpl implements CartQueryRepository {
    /**
<<<<<<< HEAD
     * @RequiredArgsConstructer 어노테이션을 활용해서 final 필드 생성자 주입 (QueryDSL 사용을 위함)
=======
     * 어노테이션 @RequiredArgsConstructor  활용해서 final 필드 생성자 주입 (QueryDSL 사용을 위함)
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
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
<<<<<<< HEAD
=======
                .innerJoin(QProduct.product).fetchJoin()
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
                .fetch();
    }

    // QueryDSL 예시를 주기 위해 만든 매서드
<<<<<<< HEAD


=======
    @Override
    public Optional<Cart> findCartWithProductsByUserId(Long userId){
        return Optional.ofNullable(queryFactory
                .selectFrom(cart)
                .innerJoin(cart.product).fetchJoin()
                .where(cart.user.id.eq(userId))
                .fetchFirst());
    }
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
}
