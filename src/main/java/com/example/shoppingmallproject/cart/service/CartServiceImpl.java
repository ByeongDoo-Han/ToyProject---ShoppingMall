package com.example.shoppingmallproject.cart.service;

<<<<<<< HEAD
public class CartServiceImpl implements CartService{
=======
import com.example.shoppingmallproject.cart.dto.CartRequestDto;
import com.example.shoppingmallproject.cart.dto.CartsWithProductsDto;
import com.example.shoppingmallproject.cart.entity.Cart;
import com.example.shoppingmallproject.cart.repository.CartRepository;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.service.ProductService;
import com.example.shoppingmallproject.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    /**
     * CartRepository 의존 주입
     */
    private final CartRepository cartRepository;

    /**
     * ProductService 의존 주입. 장바구니 로직이 product 에 매우 의존적이므로, 해당 의존 주입을 진행했습니다.
     */
    private final ProductService productService;

    /**
     * Carts 와 함께 Products 를 DTO 형태로 함께 리턴합니다. 장바구니는 항상 상품과 함께하기 때문입니다.
     * @param userId 인증객체의 아이디를 주입받습니다.
     */
    @Override
    @Transactional(readOnly = true)
    public List<CartsWithProductsDto> getCartsWithProducts(Long userId){
        List<Cart> carts = cartRepository.findCartsByUserId(1L);
        List<Product> products = new ArrayList<>();

        for (Cart cart : carts) {
            products.add(cart.getProduct());
        }

        return new CartsWithProductsDto().toDtoList(carts, products);
    }

    /**
     *
     * @param dto CartRequestDto : productID , quantity 필드를 가집니다.
     * @param user 인증객체가 요청 할 것이므로, 해당 객체의 정보를 받아와서 Cart 객체의 생성에 씁니다.
     */
    @Override
    @Transactional
    public void createCart(CartRequestDto dto, User user){
        Product product = productService.getProductById(dto.getProductId());

        Cart cart = Cart.builder()
                .product(product)
                .user(user)
                .quantity(dto.getQuantity())
                .build();

        cartRepository.save(cart);
    }
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7
}
