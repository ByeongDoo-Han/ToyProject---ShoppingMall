package com.example.shoppingmallproject.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class SignInRequestDto {

  private final String email;
  private final String password;
  private final String browser; // 프론트에서 localStorage.getItem() 함수를 이용해서 값을 세팅해야 합니다.
}
