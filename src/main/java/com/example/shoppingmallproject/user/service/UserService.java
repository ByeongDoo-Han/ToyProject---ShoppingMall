package com.example.shoppingmallproject.user.service;

import com.example.shoppingmallproject.user.dto.UserRequestDto;
import com.example.shoppingmallproject.user.dto.UserResponseDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserService  {
    UserResponseDto getUserById(Long userId);

    @Transactional
    Long userSignUp(UserRequestDto requestDto);
}
