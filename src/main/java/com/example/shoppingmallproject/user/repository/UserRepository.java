package com.example.shoppingmallproject.user.repository;

import com.example.shoppingmallproject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
<<<<<<< HEAD:src/main/java/com/example/shoppingmallproject/user/repository/UsersRepository.java
//    @Query("SELECT t FROM User t JOIN t.address")
//    Address findAddressUsingJoin(User user);
    Optional<User> findByUsername(String username);
=======
>>>>>>> a4e967323233060d176cd776fcb13de0fae1f8c7:src/main/java/com/example/shoppingmallproject/user/repository/UserRepository.java
}
