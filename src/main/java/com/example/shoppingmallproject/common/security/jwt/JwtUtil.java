package com.example.shoppingmallproject.common.security.jwt;

import com.example.shoppingmallproject.common.security.UserDetailsServiceType;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;

@Component
@RequiredArgsConstructor
public class JwtUtil {

  public Authentication createAuthentication(String username, UserDetailsServiceType userDetailsServiceType) {
    UserDetails userDetails = userDetailsFactory.getUserDetails(username, userDetailsServiceType);
    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
  }
}
