package com.Ecommerce.dao;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.Ecommerce.Repository.CartRepository;
import com.Ecommerce.Repository.ProductRepository;
import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.entities.Cart;
import com.Ecommerce.entities.Product;
import com.Ecommerce.entities.User;


@Service
public class CartDao {
	
	 private static final Logger logger = LoggerFactory.getLogger(CartDao.class);
	 
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	
	
//==============================================================METHOD FOR ADD TO CART PRODUCT====================================================================	
	
	
	public Cart addToCart( Cart cart ,int pid, Principal principal) {
		
	// find pid for check that product is null or not
	Product product = 	productRepository.findById(pid).get();

	// find that user is login or not, if user is null in that case we redirect user to login page.
	String name =	principal.getName();
	User user = userRepository.getUserByName(name);
	
	   	logger.debug("Product: {}", product);
       logger.debug("User: {}", user);
	
       if (product != null && user != null) {
    	   
    	  
    	   cart.setProduct(product);
           cart.setUser(user);
           Cart saveCarts = cartRepository.save(cart);
           logger.debug("Cart item saved successfully.");
             
           return saveCarts;
           
       } else {
           logger.debug("Product or user is null.");
           return null;
       }
       
	}
	

//=======================================================METHOD FOR SHOW ADD TO CART==============================================================================

public List<Cart> showCart(){
	
	List<Cart> cart = (List<Cart>) cartRepository.findAll();
	
	return cart;
}



//======================================================= TOTAL OF ADD TO CART ITEM METHOD================================================================	



	public int cartTotal(List<Cart> cartList) {
		 int total=0;
		for(Cart c : cartList  ) {
			
			total += c.getQuntity()*c.getProduct().getPrice();
			
		}
		return total;
	}
	
	
	
//==================================================== REMOVE CART METHOD ================================================================================

	public void removeCart(int id) {
		
		cartRepository.deleteById(id);
	}
	
	} 
	


