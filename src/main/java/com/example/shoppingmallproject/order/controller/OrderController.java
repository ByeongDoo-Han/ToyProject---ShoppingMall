package com.example.shoppingmallproject.order.controller;

import com.example.shoppingmallproject.common.security.userDetails.entity.UserDetailsImpl;
import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.order.repository.OrderRepository;
import com.example.shoppingmallproject.order.service.OrderService;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductResponseDto;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.service.OrderProductService;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.ProductRepository;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderProductService orderProductService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    // 주문페이지로 이동
    @GetMapping("/products/{productId}/order")
    public ResponseEntity<Map<String, Object>> showOrderPage(@PathVariable Long productId,
//                                                             @AuthenticationPrincipal UserDetailsImpl userDetails,
                                                             UserDetailsImpl userDetails,
                                                             @RequestHeader("quantity") Integer quantity){
        Map<String, Object> result = new HashMap<>();
        String redirectUri = "/order";
        HttpHeaders headers = new HttpHeaders();
//        headers.set("quantity", String.valueOf(quantity));
        headers.add(HttpHeaders.LOCATION, redirectUri);
//        HttpEntity<String> entity = new HttpEntity<>(headers);

        User user = userDetails.getUser();
        //order 생성,저장
        Order order = orderService.createOneOrder(productId, user, quantity);

        //orderProduct 생성,저장
        Product product = productRepository.getProductById(productId);
        OrderProduct orderProduct = orderProductService.createOneOrderProduct(order, product);

        OrderProductResponseDto dto = OrderProductResponseDto.of(orderProduct);
        result.put("data",dto);
        return ResponseEntity.ok().body(result);
    }
}
