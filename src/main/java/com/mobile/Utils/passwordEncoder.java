package com.mobile.Utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration //agar otomatis di-load oleh Spring saat aplikasi mulai
public class passwordEncoder {

  @Bean //agar dapat diakses dari kelas manapun menggunakan autowired
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
