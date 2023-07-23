package com.example.shoppingmallproject.orderProduct.controller;

import com.example.shoppingmallproject.order.dto.OrderRequestDto;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductRequestDto;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductResponseDto;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.service.OrderProductService;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderProductController {

    private final ProductRepository productRepository;
    private final OrderProductService orderProductService;

    // 상품에서 주문
//    @PostMapping("/products/{productsId}/order")
//    public void OneOrderProduct(@PathVariable Long productsId,
//                               @RequestBody OrderProductRequestDto orderProductRequestDto){
//        orderProductService.createOneOrderProduct(orderProductRequestDto);
//
//    }
}
