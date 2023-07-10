package com.example.shoppingmallproject.product.service;

import com.example.shoppingmallproject.product.entity.Product;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {

    Product getProductById(Long productId);
}
