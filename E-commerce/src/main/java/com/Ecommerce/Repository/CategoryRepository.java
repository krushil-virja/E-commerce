package com.Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ecommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
