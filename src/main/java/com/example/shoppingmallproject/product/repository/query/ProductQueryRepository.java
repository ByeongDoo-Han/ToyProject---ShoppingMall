package com.example.shoppingmallproject.product.repository.query;

import com.example.shoppingmallproject.product.entity.Product;

import java.util.List;

public interface ProductQueryRepository {
    List<Product> getProductsByCarts(List<Long> cartIds);
}
