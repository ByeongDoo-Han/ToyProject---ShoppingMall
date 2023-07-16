package com.example.shoppingmallproject.user.service;

import com.example.shoppingmallproject.user.dto.UserRequestDto;
import com.example.shoppingmallproject.user.dto.UserResponseDto;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;

public interface UserService  {
    UserResponseDto getUserById(Long userId);

    UserResponseDto userSignUp(UserRequestDto userRequestDto);

    UserResponseDto userSignIn(UserRequestDto userRequestDto, HttpServletResponse response);
}
