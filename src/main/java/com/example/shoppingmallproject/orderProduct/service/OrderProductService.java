package com.example.shoppingmallproject.orderProduct.service;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductRequestDto;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.product.entity.Product;

public interface OrderProductService {
    OrderProduct createOneOrderProduct(Order order, Product product);
}
