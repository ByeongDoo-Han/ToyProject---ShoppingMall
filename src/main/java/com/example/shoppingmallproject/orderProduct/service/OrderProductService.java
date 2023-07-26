package com.example.shoppingmallproject.orderProduct.service;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.seller.entity.Seller;

public interface OrderProductService {
    void createOrderProduct(Order order, Product product, Long quantity, Long totalPrice);
}
