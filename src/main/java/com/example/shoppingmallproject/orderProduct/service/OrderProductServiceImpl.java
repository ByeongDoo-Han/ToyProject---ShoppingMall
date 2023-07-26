package com.example.shoppingmallproject.orderProduct.service;

import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.repository.OrderProductRepository;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.seller.entity.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService{
    private final OrderProductRepository orderProductRepository;


    @Override
    @Transactional
    public void createOrderProduct(Order order, Product product, Seller seller, Long quantity, Long totalPrice) {
        OrderProduct orderProduct = OrderProduct.builder()
                .order(order)
                .product(product)
                .seller(seller)
                .quantity(quantity.intValue())
                .totalPrice(totalPrice).build();
        orderProductRepository.save(orderProduct);
    }
}
