package com.example.shoppingmallproject.user.controller;

import com.example.shoppingmallproject.user.dto.UserRequestDto;
import com.example.shoppingmallproject.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void userSignUpTest(){
        when(userService.userSignUp(new UserRequestDto())).thenReturn(1L);
    }

}