package com.example.shoppingmallproject.cart.entity;

import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private Long quantity;

    @Builder
    public Cart(Product product, User user, Long quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }
}
