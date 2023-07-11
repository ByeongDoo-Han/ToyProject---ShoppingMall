package com.example.shoppingmallproject.cart.dto;

import com.example.shoppingmallproject.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartRequestDto {
    private Long productId;
    private Long quantity;
}
