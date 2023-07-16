package com.example.shoppingmallproject.delivery.entity;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderPayDelivery> orderPayDelivery;
    @Column(nullable = false)
    private String address;

    @Builder
    public Delivery(List<OrderPayDelivery> orderPayDelivery, String address) {
        this.orderPayDelivery = orderPayDelivery;
        this.address = address;
    }
}
