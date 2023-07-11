package com.example.shoppingmallproject.product.entity;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import com.example.shoppingmallproject.seller.entity.Seller;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Product extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String detail;
    @ManyToOne(fetch = FetchType.LAZY)
    private Seller seller;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Long stock;
    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderPayDelivery> orderPayDelivery;

    @Builder
    public Product(String name, String detail, Seller seller, Long price, Long stock, List<OrderPayDelivery> orderPayDelivery) {
        this.name = name;
        this.seller = seller;
        this.detail = detail;
        this.price = price;
        this.stock = stock;
        this.orderPayDelivery = orderPayDelivery;
    }
}
