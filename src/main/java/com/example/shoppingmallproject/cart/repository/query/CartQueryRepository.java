package com.example.shoppingmallproject.cart.repository.query;

import com.example.shoppingmallproject.cart.entity.Cart;

import java.util.List;
<<<<<<< HEAD

public interface CartQueryRepository {
    List<Cart> findCartsByUserId(Long userId);
=======
import java.util.Optional;

public interface CartQueryRepository {
    List<Cart> findCartsByUserId(Long userId);

    // QueryDSL 예시를 주기 위해 만든 매서드
    Optional<Cart> findCartWithProductsByUserId(Long userId);
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
}
