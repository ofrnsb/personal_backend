package com.mobile.Modals.Repositories;

import com.mobile.Modals.Entities.Appuser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<Appuser, Long> {
  Optional<Appuser> findByEmail(String email);
}
