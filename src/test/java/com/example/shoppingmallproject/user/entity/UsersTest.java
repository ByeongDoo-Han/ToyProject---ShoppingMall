package com.example.shoppingmallproject.user.entity;

import com.example.shoppingmallproject.address.entity.Address;
import com.example.shoppingmallproject.address.repository.AddressRepository;
import com.example.shoppingmallproject.user.repository.UsersRepository;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.logging.Logger;
@SpringBootTest
public class UsersTest {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Test
    public void onetoonetest(){
        String email = "quden04@gmail.com";
        Address address= Address.builder()
            .userAddress("광명시")
            .userId(1L)
            .build();
        User user1 = User.builder()
            .email(email)
            .password("asdf")
            .phone("010-1234-1234")
            .username("병두")
            .build();
        usersRepository.saveAndFlush(user1);
        addressRepository.saveAndFlush(address);
        System.out.println("user검색==============");
        User user2 = usersRepository.findByEmail(user1.getEmail()).orElseThrow(
            () -> new NullPointerException()
        );
        System.out.println("address검색===========");
        Address address2 = addressRepository.findById(address.getId()).orElseThrow(
            () -> new NullPointerException()
        );
        System.out.println("user검색2==============");
        User resultUser = usersRepository.findById(1L).get();
        System.out.println("address검색2===========");
        Address resultAddress = resultUser.getAddress();
        System.out.println("add검색3========");
        Address resultAddress2 = usersRepository.findAddressUsingJoin(resultUser);
    }



}