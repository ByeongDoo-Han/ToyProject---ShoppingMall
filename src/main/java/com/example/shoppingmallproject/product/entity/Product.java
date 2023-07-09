package com.example.shoppingmallproject.product.entity;

import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Product extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String detail;
    private Long sellerId;
    private Long price;
    private Long stock;

    @Builder
    public Product(String name, String detail, Long sellerId, Long price, Long stock) {
        this.name = name;
        this.detail = detail;
        this.sellerId = sellerId;
        this.price = price;
        this.stock = stock;
    }
}
