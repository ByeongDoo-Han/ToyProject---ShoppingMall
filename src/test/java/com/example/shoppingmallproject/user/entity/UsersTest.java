package com.example.shoppingmallproject.user.entity;

import com.example.shoppingmallproject.address.entity.Address;
import com.example.shoppingmallproject.address.repository.AddressRepository;
import com.example.shoppingmallproject.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Test
    public void oneToOneTest(){
        String email = "quden04@gmail.com";
        Address address= Address.builder()
            .userAddress("광명시")
            .build();
        User user1 = User.builder()
            .email(email)
            .password("asdf")
            .phone("010-1234-1234")
            .username("병두")
            .build();
        userRepository.saveAndFlush(user1);
        addressRepository.saveAndFlush(address);
        System.out.println("user검색==============");
        User user2 = userRepository.findByEmail(user1.getEmail()).orElseThrow(
            () -> new NullPointerException()
        );
        System.out.println("address검색===========");
        Address address2 = addressRepository.findById(address.getId()).orElseThrow(
            () -> new NullPointerException()
        );
        System.out.println("user검색2==============");
        User resultUser = userRepository.findById(1L).get();
        System.out.println("address검색2===========");
        System.out.println("add검색3========");
    }



}