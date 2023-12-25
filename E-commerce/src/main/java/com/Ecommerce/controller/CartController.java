package com.Ecommerce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ecommerce.dao.CartDao;
import com.Ecommerce.entities.Cart;

@Controller
public class CartController {
	
	@Autowired
	private CartDao cartDao;
	
//==================================================== Add To Cart Handler ===============================================================================
    @PostMapping("/addToCart")
    public String  addToCart(@ModelAttribute Cart cart, @RequestParam("pid") int pid, Principal principal) {
   
          cartDao.addToCart(cart, pid, principal);
          return "redirect:/index";
    }


//==================================================== Remove Cart Handler ===============================================================================

@GetMapping("/removeCart/{id}")
public String removeCart(@PathVariable ("id") Integer id) {
	
	cartDao.removeCart(id);
	return  "redirect:/viewCart";
	
}


}
