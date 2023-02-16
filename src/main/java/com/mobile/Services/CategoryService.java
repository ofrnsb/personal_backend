package com.mobile.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.Modals.Entities.Category;
import com.mobile.Modals.Repositories.CategoryRepo;

import jakarta.transaction.TransactionScoped;

@Service
@TransactionScoped
public class CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;

  public Category save(Category category) {
    if (category.getId() != null) {
      Category currentCategory = categoryRepo.findById(category.getId()).get();
      currentCategory.setName(category.getName());
      category = currentCategory;
    }
    return categoryRepo.save(category);
  }

  public Category findOne(Long id) {
    Optional<Category> category = categoryRepo.findById(id);
    if (!category.isPresent()) {
      return null;
    }
    return category.get();
  }

  public Iterable<Category> findAll() {
    return categoryRepo.findAll();
  }

  public void removeOne(Long id) {
    categoryRepo.deleteById(id);
  }
}
