package com.example.shoppingmallproject.orderPayDelivery.repository;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
