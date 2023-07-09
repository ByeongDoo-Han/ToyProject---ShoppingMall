package com.example.shoppingmallproject.user.entity;

import com.example.shoppingmallproject.address.entity.Address;
import com.example.shoppingmallproject.share.TimeStamped;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Builder
@Getter
@NoArgsConstructor
@Table(name = "Users")
public class User extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Builder
    public User(String username, String email, String password, String phone, Address address) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
