package com.Ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.Repository.CategoryRepository;
import com.Ecommerce.entities.Category;

@Service
public class CategoryDao {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public Category addCategory(Category category) {
		
		Category c = categoryRepository.save(category);
		return c;
		}
	
	
	
	public List<Category> showAllCategory(){
		
		List<Category> showAllCategory = categoryRepository.findAll();
		
		return showAllCategory;
	}
	
	
	public void deleteCategory(int id) {
		
		categoryRepository.deleteById(id);
	}
	
	
	public Optional<Category> findCategoryById(int id) {
	    Optional<Category> findCategoryById = categoryRepository.findById(id);
	    return findCategoryById;
	}
	
	
	/*
	 * public Category updateCategory(Category category) {
	 * 
	 * Category c = categoryRepository.save(category); return c; }
	 */

}
