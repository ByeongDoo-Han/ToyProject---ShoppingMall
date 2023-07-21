package com.example.shoppingmallproject.cart.controller;

import com.example.shoppingmallproject.cart.dto.CartsWithProductsDto;
import com.example.shoppingmallproject.cart.service.CartService;
import com.example.shoppingmallproject.common.security.jwt.JwtUtil;
import com.example.shoppingmallproject.common.security.userDetails.entity.UserDetailsImpl;
import com.example.shoppingmallproject.user.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(CartController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class CartControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    JwtUtil jwtUtil;

    @MockBean
    private CartService cartService;

    private UserDetailsImpl userDetails;
    private User user;
    @BeforeEach
    void setUp(){
        user = mock(User.class); // user 목 객체 생성
        when(user.getId()).thenReturn(1L); // 유저의 아이디는 1로
        userDetails = mock(UserDetailsImpl.class);
        when(userDetails.getUser()).thenReturn(user);  // userDetailsImpl 에서 getUSER() 호출 시 위 유저 반환하도록 설정
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(new UsernamePasswordAuthenticationToken(userDetails, null, null));
    }

    @Test
    void getCartsWithProducts() throws Exception {
        Long userId = 1L;
        List<CartsWithProductsDto> expectedCartsWithProducts = new ArrayList<>();
//        when(userDetails.getUser()).thenReturn(user);
        when(cartService.getCartsWithProducts(userId)).thenReturn(expectedCartsWithProducts);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/carts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(expectedCartsWithProducts.size()));

        verify(cartService, times(1)).getCartsWithProducts(userId);
    }
}