package com.example.shoppingmallproject.address.entity;

import com.example.shoppingmallproject.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS")
@Builder
@Slf4j
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
}
