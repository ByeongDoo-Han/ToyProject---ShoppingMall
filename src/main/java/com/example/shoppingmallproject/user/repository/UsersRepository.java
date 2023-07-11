package com.example.shoppingmallproject.user.repository;

import com.example.shoppingmallproject.address.entity.Address;
import com.example.shoppingmallproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
//    @Query("SELECT t FROM User t JOIN t.address")
//    Address findAddressUsingJoin(User user);
    Optional<User> findByUsername(String username);
}
