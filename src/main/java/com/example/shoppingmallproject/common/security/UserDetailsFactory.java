package com.example.shoppingmallproject.common.security;

import java.util.HashMap;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsFactory {

  private final HashMap<UserDetailsServiceType, UserDetailsServiceAddGetType> serviceMap = new HashMap<>();

  public UserDetailsFactory(List<UserDetailsServiceAddGetType> userDetailsServiceAddGetTypes) {
    for(UserDetailsServiceAddGetType userDetailsServiceAddGetType : userDetailsServiceAddGetTypes){
      serviceMap.put(userDetailsServiceAddGetType.getServiceType(), userDetailsServiceAddGetType);
    }
  }

  public UserDetails getUserDetails(String loginId,UserDetailsServiceType userDetailsServiceType){
    UserDetailsServiceAddGetType userDetailsService = serviceMap.get(userDetailsServiceType);
    return userDetailsService.loadUserByUsername(loginId);
  }

}
