package com.mobile.Utils;

import com.mobile.Services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

  @Autowired
  BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  AppUserService appUserService;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable()
      // .authorizeHttpRequests(requests ->
      //   requests
      //     // .requestMatchers("/api/categories")

      //     .anyRequest()
      //     .permitAll()
      // )
      .httpBasic()
      .and()
      .authenticationManager(authenticationManager(http));

    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http)
    throws Exception {
    return http
      .getSharedObject(AuthenticationManagerBuilder.class)
      .userDetailsService(appUserService)
      .passwordEncoder(bCryptPasswordEncoder)
      .and()
      .build();
  }
}
