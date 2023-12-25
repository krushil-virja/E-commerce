package com.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Ecommerce.Repository.UserRepository;
import com.Ecommerce.dao.CartDao;
import com.Ecommerce.dao.ProductDao;
import com.Ecommerce.entities.Cart;
import com.Ecommerce.entities.Contact;
import com.Ecommerce.entities.Product;
import com.Ecommerce.entities.User;


@Controller
public class basicController {
	
	@Autowired
	private ProductDao pdao;
	
	@Autowired
	private CartDao cdao;
	
	@Autowired
	private UserRepository userRepository;
	
//=============================================================== Handler for get USER INDEX page  ===========================================================================
	
	@GetMapping("/index")
	public String index(Model m) {
		 
		List<Product> showAllProduct = pdao.showAllProduct();
		m.addAttribute("product", showAllProduct);
		
		
		
		
		return "index"; 
	}
	
	
//=============================================================== Handler for get USER CONTACT page =====================================================================	
	@GetMapping("/contact")
	public String contact(Model m) {
		
		m.addAttribute("contact",new Contact());
		return "contact";
	}
	
//============================================================ Handler for get USER PRODUCT page ========================================================================
	@GetMapping("/product")
	public String product(Model m ) {
		
		List<Product> showAllProduct = pdao.showAllProduct();
		m.addAttribute("product", showAllProduct);
		return "product";
	}
	
//========================================================== Handler for get USER ABOUT page =======================================================================
	@GetMapping("/about")
	public String about() {
		
		return "about";
	}
	
//=========================================================== Handler for get USER REGISTER page ===================================================================
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
//==============================================================handler for get USER LOGIN page ===================================================================
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
//==============================================================Handler for logout =====================================================================

	@GetMapping("/logout")
 public String  logout() {
	return "/login";
	 
 }
//============================================================== Handler for GET SHOW CART PAGE ====================================================================

@GetMapping("/viewCart")
public String viewCart(Model m ) {
	

	List<Cart> showCart = cdao.showCart();
	int cartTotal = cdao.cartTotal(showCart);
	
	m.addAttribute("cart", showCart);
	m.addAttribute("cartTotal", cartTotal);
	
	
	return "viewCart";
}



//=============================================================== Handler for GET WISHLIST PAGE=======================================================================

@GetMapping("/wishList")
public String viewWishList() {
	
	return "wishList";
	
}

@GetMapping("/register2")
public String userID9() {

	return "register2";
}



}
