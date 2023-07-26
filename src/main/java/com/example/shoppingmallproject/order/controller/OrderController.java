package com.example.shoppingmallproject.order.controller;

import com.example.shoppingmallproject.common.security.userDetails.entity.UserDetailsImpl;
import com.example.shoppingmallproject.order.dto.OrderRequestDto;
import com.example.shoppingmallproject.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Long> createOrder(@RequestBody OrderRequestDto dto,
                                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        Long orderId = orderService.createOrder(dto, userDetails.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body(orderId);
    }
}
