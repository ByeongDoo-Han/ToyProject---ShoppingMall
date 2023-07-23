package com.example.shoppingmallproject.order.controller;

import com.example.shoppingmallproject.common.security.userDetails.entity.UserDetailsImpl;
import com.example.shoppingmallproject.order.entity.Order;
import com.example.shoppingmallproject.order.service.OrderServiceImpl;
import com.example.shoppingmallproject.orderProduct.dto.OrderProductResponseDto;
import com.example.shoppingmallproject.orderProduct.entity.OrderProduct;
import com.example.shoppingmallproject.orderProduct.service.OrderProductServiceImpl;
import com.example.shoppingmallproject.product.entity.Product;
import com.example.shoppingmallproject.product.repository.ProductRepository;
import com.example.shoppingmallproject.product.service.ProductServiceImpl;
import com.example.shoppingmallproject.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class OrderControllerTest {
    OrderController orderControllerMock = mock(OrderController.class);
    OrderServiceImpl orderServiceMock = mock(OrderServiceImpl.class);
    ProductServiceImpl productServiceMock = mock(ProductServiceImpl.class);
    User userMock = mock(User.class);
    Order orderMock = mock(Order.class);
    Product productMock = mock(Product.class);
    OrderProduct orderProductMock = mock(OrderProduct.class);
    UserDetailsImpl userDetailsMock = mock(UserDetailsImpl.class);
    OrderProductServiceImpl orderProductServiceMock = mock(OrderProductServiceImpl.class);

//    MockMvc mockMvc = mock(MockMvc.class);
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private WebApplicationContext wac;
    @Mock
    private ProductRepository productRepository;

    @Test
    void showOrderPageTest() throws Exception {
        OrderProductResponseDto expectedDto = new OrderProductResponseDto();
        given(productMock.getId()).willReturn(1L);
        given(orderMock.getId()).willReturn(1L);
        given(orderProductMock.getId()).willReturn(1L);

        given(userDetailsMock.getUser()).willReturn(userMock);

        orderControllerMock.showOrderPage(productMock.getId(),userDetailsMock,1);

//        verify(orderServiceMock, times(1)).createOneOrder(1L, userMock, 1);

//        verify(productServiceMock, times(1)).getProductById(productMock.getId());

//        verify(orderProductServiceMock, times(1)).createOneOrderProduct(orderMock, productMock);

//        mockMvc.perform(
//            get("/products/1/order")
//                .header("quantity", 1)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk())
//
//            .andExpect(handler().handlerType(OrderController.class))
//            .andDo(print());
        verify(orderControllerMock, times(1)).showOrderPage(productMock.getId(),userDetailsMock,1);


    }


}