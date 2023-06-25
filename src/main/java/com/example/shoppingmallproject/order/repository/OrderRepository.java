package com.example.shoppingmallproject.order.repository;

import com.example.shoppingmallproject.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface OrderRepository extends JpaRepository<Orders, BigInteger> {
}
