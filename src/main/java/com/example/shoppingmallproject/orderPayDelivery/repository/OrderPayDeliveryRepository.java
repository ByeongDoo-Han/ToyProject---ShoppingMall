package com.example.shoppingmallproject.orderPayDelivery.repository;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPayDeliveryRepository extends JpaRepository<OrderPayDelivery, Long> {

}
