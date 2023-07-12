package com.example.shoppingmallproject.product.service;

import com.example.shoppingmallproject.product.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

    Product getProductById(Long productId);

    @Transactional(readOnly = true)
    List<Product> getProductsByCartIds(List<Long> cartIds);
}
