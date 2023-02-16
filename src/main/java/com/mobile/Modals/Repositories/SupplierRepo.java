package com.mobile.Modals.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.mobile.Modals.Entities.Supplier;

//PagingAndSortingRepository => memiliki fitur untuk paging dan sorting serta fitur CRUD milik CrudRepository
//JpaRepository => memiliki semua fitur dari CrudRepository dan PagingAndSortingRepository serta fitur-fitur JPA (fitur save and flush)
//jika tidak pakai JpaRepository, saat melakukan save/delete maka hanya akan save/delete pada entity yang terkait (tidak melakukan flush)

public interface SupplierRepo extends CrudRepository<Supplier, Long> {
  //derived querry
  Supplier findByEmail(String email);
}
