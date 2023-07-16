package com.example.shoppingmallproject.user.dto;

import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.Column;
import lombok.Builder;
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

    @Builder
    public UserRequestDto(String email, String password, String username, String phone) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.phone = phone;
    }
}
