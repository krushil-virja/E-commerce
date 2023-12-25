package com.Ecommerce.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.Ecommerce.Repository.ProductRepository;
import com.Ecommerce.entities.Product;

@Service
public class ProductDao {

	@Autowired
	private ProductRepository productRepository;

//=================================================================METHOD FOR ADD PRODUCT ==============================================================================================================
	public Product addProduct(Product product) {
		
		Product saveProduct = productRepository.save(product);
		
		return saveProduct;
		
	}
	
	
	public List<Product> showAllProduct(){
		
		List<Product> showProduct = productRepository.findAll();
		
		
		
		
		return showProduct;
	}
	
	
//==================================================================== METHOD FOR DELETE SPECIFIC PRODUCT ==============================================================================================	
	public void deleteProduct(int id) {
	    productRepository.deleteById(id);
	}
	
}
