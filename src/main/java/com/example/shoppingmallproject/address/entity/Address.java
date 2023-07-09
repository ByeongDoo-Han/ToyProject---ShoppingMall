package com.example.shoppingmallproject.address.entity;

import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Long id;
    @Column
    private String userAddress;
    @Column
    private Long userId;
    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private User users;

    @Builder
    public Address(String userAddress, Long userId, User users) {
        this.userAddress = userAddress;
        this.userId = userId;
        this.users = users;
    }
}
