package com.example.shoppingmallproject.user.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    private String email;
    private String password;
    private String username;
    private String phone;
}
