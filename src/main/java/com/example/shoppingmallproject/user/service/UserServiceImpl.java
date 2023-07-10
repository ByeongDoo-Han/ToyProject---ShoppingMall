package com.example.shoppingmallproject.user.service;

import com.example.shoppingmallproject.user.entity.User;
import com.example.shoppingmallproject.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(
                () -> new NoSuchElementException("아이디에 해당하는 유저가 없습니다.")
        );
    }
}
