package com.example.shoppingmallproject.product.repository;

import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.query.ProductQueryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductQueryRepository {

}
