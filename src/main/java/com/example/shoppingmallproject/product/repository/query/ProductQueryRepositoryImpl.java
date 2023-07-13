package com.example.shoppingmallproject.product.repository.query;

import com.example.shoppingmallproject.cart.entity.QCart;
import com.example.shoppingmallproject.product.entity.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.shoppingmallproject.product.entity.QProduct.product;

@Repository
@RequiredArgsConstructor
public class ProductQueryRepositoryImpl implements ProductQueryRepository{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> getProductsByCarts(List<Long> cartIds) {
        return jpaQueryFactory.selectFrom(product)
                .innerJoin(QCart.cart)
                .on(product.eq(QCart.cart.product))
                .where(QCart.cart.id.in(cartIds))
                .fetch();
    }

}
