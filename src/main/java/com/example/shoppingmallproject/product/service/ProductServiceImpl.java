package com.example.shoppingmallproject.product.service;

import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Transactional(readOnly = true)
    @Override
    public Product getProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(
                () -> new NoSuchElementException("해당 상품이 존재하지 않습니다.")
        );
    }


}
