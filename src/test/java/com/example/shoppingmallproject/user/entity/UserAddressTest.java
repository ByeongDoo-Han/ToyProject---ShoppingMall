package com.example.shoppingmallproject.user.entity;

import com.example.shoppingmallproject.address.entity.Address;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserAddressTest {

    @DisplayName("cascadeType.ALL 결과 테스트")
    @Test
    void cascadeTypeAll(){
        String username = "asdf";
        String password = "asdf";
        String phone = "1234";
        LinkedHashSet<Address> addresses = new LinkedHashSet();
        String email = "asdf@gmail.com";

        User user1 = User.builder()
            .phone(phone)
            .email(email)
            .password(password)
            .username(username)
            .build();


    }

}