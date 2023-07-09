package com.example.shoppingmallproject.seller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;
  private String password;
  private String phone;

  public Seller(String name, String email, String password, String phone) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.phone = phone;
  }
}
