package com.mobile.Modals.Repositories;

import com.mobile.Modals.Entities.Product;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ProductRepo extends JpaRepository<Product, Long> {
  @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
  public List<Product> findByName(@PathParam("name") String name);

  // @Query(value = "CALL coba1(:productId);", nativeQuery = true)
  // public Product accessSP(@Param("productId") Long productId);

  @Procedure(name = "coba1")
  public String coba1(Long productId); //nama method harus sama dengan nama SP
}
