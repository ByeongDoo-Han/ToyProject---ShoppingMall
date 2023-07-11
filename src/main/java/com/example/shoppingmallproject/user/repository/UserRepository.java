package com.example.shoppingmallproject.user.repository;

import com.example.shoppingmallproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.example.shoppingmallproject.user.entity.QUser.user;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
