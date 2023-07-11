package com.example.shoppingmallproject.delivery.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long orderItem;
    @Column(nullable = false)
    private String address;

    @Builder
    public Delivery(Long orderItem, String address) {
        this.orderItem = orderItem;
        this.address = address;
    }
}
