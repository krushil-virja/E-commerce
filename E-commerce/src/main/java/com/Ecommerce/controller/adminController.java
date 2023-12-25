package com.Ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Ecommerce.dao.AdminDao;
import com.Ecommerce.dao.CategoryDao;
import com.Ecommerce.dao.ContactDao;
import com.Ecommerce.dao.ProductDao;
import com.Ecommerce.dao.UserDao;
import com.Ecommerce.entities.Category;
import com.Ecommerce.entities.Contact;
import com.Ecommerce.entities.Product;
import com.Ecommerce.entities.User;

@Controller

@RequestMapping("/admin")     // now in these case we have to call url localhost:port/admin/*** to get particular page
public class adminController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private AdminDao adao;
	
	@Autowired
	private ContactDao cdao;
	
	@Autowired
	private ProductDao pdao;
	
//============================================================= LOGIN PAGE HANDLER==================================================================================	
	  @GetMapping("/login")
	  public String login(Model m) {
	  
	  m.addAttribute("title", "Admin-index");
	  
	  return "Admin/admin-login";
	  
	  }
	 

	
//=========================================================ADMIN INDEX PAGE HANDLER ================================================================================
	 
	 @GetMapping("/index")
	 public String index() {
	 
	 return "Admin/admin-index";
	 
	 }
//=========================================================GET ALL LOGIN USER HANDLER==============================================================================
	 
	 @GetMapping("/allUser")
	 public String showAllUser(Model m) {
		 
		 List<User> allUser = adao.allUser();
		 
		 m.addAttribute("user", allUser);
		 return "Admin/admin-user";
	 }

//======================================================== SHOW ALL CATEGORY HANDLER ===============================================================================
	@GetMapping("/category")
	public String allCategory(Model m) {
		
		List<Category> category = categoryDao.showAllCategory(); // using this we show all category
		
		m.addAttribute("category", category); // 
		
		return "Admin/admin-category";
	}
	
//=======================================================SHOW ALL PRODUCT HANDLER =================================================================================	
	 
      @GetMapping("/product") 
	  public String allProduct(Model m) {
    	  
    	  List<Product> product = pdao.showAllProduct();
    	  
    	  m.addAttribute("product", product);
    	  
	  
	  return "Admin/admin-product";
	  
	  }
	 

//=====================================================GET ADD CATEGORY FORM HANDLER =============================================================================
	
    @GetMapping("/addCategory")
	public String addCategory() {
		
		return "Admin/admin-addCategory";
	}
	
//====================================================GET ADD PRODUCT FORM HANDLER ================================================================================	
	
   @GetMapping("/addProduct")
	public String addProduct(Model m) {
		
		 List<Category> categories = categoryDao.showAllCategory();
		 System.out.println("Number of categories fetched: " + categories.size()); // Add this line for debugging
		    m.addAttribute("category", categories);
		return "Admin/admin-addProduct";
	}
	
//================================================GET ALL USER INQIRY(CONTACT) HANDLER ============================================================================
	
   @GetMapping("/inquery")
	public String userInquery(Model m) {
	   
	  
		   List<Contact> contact = cdao.showAllContact();
		   System.out.println("Number of contact fetched: " + contact.size()); // Add this line for debugging

		   m.addAttribute("contact", contact);
	   
	   
		return "Admin/admin-inquery";
	}
	
// ================================================ Get UPDATE FORM FOR UPDATE PARTICULAR CATEGORY ================================================================

	/*
	 * @GetMapping("/updateCategory/{id}") public String updateCategory(Model m
	 * , @PathVariable("id") Integer id) { Optional<Category> category =
	 * categoryDao.findCategoryById(id);
	 * 
	 * m.addAttribute("category", category); return "Admin/admin-updateCategory";
	 * 
	 * }
	 */
   
   
   @GetMapping("/updateCategory/{id}")
   public String updateCategory(Model m, @PathVariable("id") Integer id) {
       Optional<Category> categoryOptional = categoryDao.findCategoryById(id);
       Category category = categoryOptional.orElse(new Category()); // or handle the case when Optional is empty
       m.addAttribute("category", category);
       return "Admin/admin-updateCategory";
   }
   
   
}
