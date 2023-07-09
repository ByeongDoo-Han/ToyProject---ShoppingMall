package com.example.shoppingmallproject.common.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig implements WebMvcConfigurer {

//  private final JwtUtil jwtUtil

  @Bean
  public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

  @Bean
  protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
    http.httpBasic().disable()
        .csrf().disable()
        .formLogin().disable();
    http
        .headers()
        .xssProtection()
        .and()
        .contentSecurityPolicy("script-src 'self'");
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 세션이 필요하면 생성하도록 셋팅

    http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
        .requestMatchers("").permitAll()
        .anyRequest().authenticated();
//        .and()
//        .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
//        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//        .and()
//        .addFilterBefore(new UserAuthFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
//        .addFilterBefore(new AdminAuthFilter(jwtUtil), UserAuthFilter.class);

    return http.build();
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD")
        .exposedHeaders("Authorization");
  }

}
