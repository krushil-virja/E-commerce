package com.Ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Ecommerce.Repository.CategoryRepository;
import com.Ecommerce.dao.CategoryDao;
import com.Ecommerce.entities.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	CategoryRepository categoryRepository;

//===========================================================Handler for ADD CATEGORY===============================================================================================================
	
	
	@PostMapping("/insertCategory")
	public String AddCategory(@ModelAttribute Category category, @RequestParam("cat_image") MultipartFile file) {
	
		try {
			
			// for add image to the its desire path
			
			if(file.isEmpty()) {
				
				System.out.println("your file is empty");
				
			}
			else {
				// first we got the file name which is set by user in form
				category.setCimage(file.getOriginalFilename());
				
				// now we store image in particular path.
				File saveFile = new ClassPathResource("static/images").getFile();   
				
				Path path = Paths.get(saveFile.getAbsolutePath()+ File.separator + file.getOriginalFilename());
				
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
				
				
				System.out.println("image is uploaded");
			}
			
			Category c = categoryDao.addCategory(category);


				
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:addCategory";  // here we have to give getmapping url not jsp file name. here i give only addCategory insed of /admin/addCategory cause i already mention admin in controller upper side
		
	}
	
//========================================================= DELETE CATEGORY HANDLER ================================================================================
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") Integer id, Model model) {
        categoryDao.deleteCategory(id);
		return "redirect:/admin/category";
	
}
	
//=============================================================UPDATE CATEGORY HANDLER ==========================================================================

@PostMapping("/updateCategory")
public String updateCategory( @ModelAttribute Category category, @RequestParam("cat_image") MultipartFile file, Model m ) throws IOException {
	
	System.out.println("category name is " + category.getCname());
	
	Optional<Category> updateCategory = categoryDao.findCategoryById(category.getId());
	
	if(updateCategory.isPresent()) {
		
		Category category2 = updateCategory.get();
		
		categoryRepository.save(category2);
		
	}
	else {
		// if category is not exits, save the new category
		
		categoryRepository.save(category);
	}
	
		return "redirect:/admin/category";
	
	


	
	
	
	
}	

}


