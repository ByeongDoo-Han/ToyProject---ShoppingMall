package com.example.shoppingmallproject.cart.controller;

import com.example.shoppingmallproject.cart.dto.CartsWithProductsDto;
import com.example.shoppingmallproject.cart.service.CartService;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    /**
     * @param user 인증 객체
     * @return 장바구니 객체와 프로덕트 객체를 리턴합니다.
     */
    @GetMapping("/carts")
    public List<CartsWithProductsDto> getCartsWithProducts(@AuthenticationPrincipal User user){
        return cartService.getCartsWithProducts(user.getId());
    }
}
