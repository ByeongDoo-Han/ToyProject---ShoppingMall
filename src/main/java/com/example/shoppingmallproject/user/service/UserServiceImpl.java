package com.example.shoppingmallproject.user.service;

import com.example.shoppingmallproject.user.dto.UserRequestDto;
import com.example.shoppingmallproject.user.dto.UserResponseDto;
import com.example.shoppingmallproject.user.entity.User;
import com.example.shoppingmallproject.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long userId){
        return UserResponseDto.of(userRepository.findById(userId).orElseThrow(
                () -> new NoSuchElementException("아이디에 해당하는 유저가 없습니다.")
        ));
    }
    @Override
    @Transactional(readOnly = true)
    public UserResponseDto userSignUp(UserRequestDto requestDto) {
        String email = requestDto.getEmail();
        String password = passwordEncoder.encode(requestDto.getPassword());
        String username = requestDto.getUsername();
        String phone = requestDto.getPhone();

//        Optional<User> found = userRepository.findByEmail(email);
        validateEmail(email);

//        if (found.isPresent()) {
//            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
//        }

        User user = User.builder()
                .phone(phone)
                .email(email)
                .username(username)
                .password(password)
                .build();

        userRepository.save(user);
        return UserResponseDto.of(user);
//        return user.getId(); // 생성되는 유저의 id를 반환해서, Controller 단에서 생성된 유저의 URI 를 정확히 참조하도록 함.
    }

    @Transactional
    public void validateEmail(String email) {
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }
    }

    @Override
    public UserResponseDto userSignIn(UserRequestDto userRequestDto, HttpServletResponse response) {
        return null;
    }
}
