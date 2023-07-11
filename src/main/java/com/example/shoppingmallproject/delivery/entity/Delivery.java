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
    private Long orderItemId;
    @Column(nullable = false)
    private String address;

    @Builder
    public Delivery(Long orderItemId, String address) {
        this.orderItemId = orderItemId;
        this.address = address;
    }
}
