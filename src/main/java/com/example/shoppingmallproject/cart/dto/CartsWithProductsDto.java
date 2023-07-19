package com.example.shoppingmallproject.cart.dto;

import com.example.shoppingmallproject.cart.entity.Cart;
import com.example.shoppingmallproject.product.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Getter
@NoArgsConstructor
public class CartsWithProductsDto {
    private Cart cart;
    private Product product;

    private CartsWithProductsDto(Cart cart, Product product) {
        this.cart = cart;
        this.product = product;
    }

    public static CartsWithProductsDto of(Cart cart, Product product){
        return new CartsWithProductsDto(cart, product);
    }

    public List<CartsWithProductsDto> toDtoList(List<Cart> carts, List<Product> products){
        List<CartsWithProductsDto> dtoList = new ArrayList<>();

        for (int i = 0; i < carts.size(); i++) {
            CartsWithProductsDto dto = CartsWithProductsDto.of(carts.get(i), products.get(i));
            dtoList.add(dto);
        }

        return dtoList;
    }
}
