package com.mobile.Modals.Repositories;

import com.mobile.Modals.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//PagingAndSortingRepository => memiliki fitur untuk paging dan sorting serta fitur CRUD milik CrudRepository
//JpaRepository => memiliki semua fitur dari CrudRepository dan PagingAndSortingRepository serta fitur-fitur JPA (fitur save and flush)
//jika tidak pakai JpaRepository, saat melakukan save/delete maka hanya akan save/delete pada entity yang terkait (tidak melakukan flush)

public interface CategoryRepo extends JpaRepository<Category, Long> {
  // we gonna make some sorthing here
  //
}
