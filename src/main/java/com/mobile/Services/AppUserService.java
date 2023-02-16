package com.mobile.Services;

import com.mobile.Modals.Entities.Appuser;
import com.mobile.Modals.Repositories.AppUserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AppUserService implements UserDetailsService {

  @Autowired
  private AppUserRepo appUserRepo;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String email)
    throws UsernameNotFoundException {
    return appUserRepo
      .findByEmail(email)
      .orElseThrow(() ->
        new UsernameNotFoundException(
          String.format("user with email '%s' not found", email)
        )
      );
  }

  public Iterable<Appuser> getAllAppusers() {
    return appUserRepo.findAll();
  }

  public Appuser registerAppuser(Appuser user) {
    boolean isExist = appUserRepo.findByEmail(user.getEmail()).isPresent();
    if (isExist) {
      throw new RuntimeException(
        String.format(
          "user with email %s is already registered",
          user.getEmail()
        )
      );
    } else {
      String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);
      return appUserRepo.save(user);
    }
  }
}
