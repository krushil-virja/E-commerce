package com.Ecommerce.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

import com.Ecommerce.dao.ProductDao;
import com.Ecommerce.entities.Product;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	private ProductDao productDao;
	

//===============================================================================HANDLER FOR INSERT PRODUCT=============================================================================================

@PostMapping("/insertProduct")
public String addProduct(@ModelAttribute  Product product, @RequestParam("image1") MultipartFile file1, @RequestParam("image2") MultipartFile file2 , @RequestParam ("image3") MultipartFile file3, @RequestParam("image4") MultipartFile file4) {

	try {
		
		if (file1.isEmpty() && file2.isEmpty() && file3.isEmpty() && file4.isEmpty()) {
		    
		}
		else {
			
			product.setPimage1(file1.getOriginalFilename());
			product.setPimage2(file2.getOriginalFilename());
			product.setPimage3(file3.getOriginalFilename());
			product.setPimage4(file4.getOriginalFilename());
			
			// now we fetch the file upload path so we have class 
			File file = new ClassPathResource("static/images").getFile();
			 
			    InputStream inputStream1 = file1.getInputStream();
			    InputStream inputStream2 = file2.getInputStream();
			    InputStream inputStream3 = file3.getInputStream();
			    InputStream inputStream4 = file4.getInputStream();
			    
			    //	Path path = Paths.get(saveFile.getAbsolutePath()+ File.separator + file.getOriginalFilename());
			    Path path1 = Paths.get(file.getAbsolutePath() + File.separator + file1.getOriginalFilename());
			    Path path2 = Paths.get(file.getAbsolutePath() + File.separator + file2.getOriginalFilename());
			    Path path3 = Paths.get(file.getAbsolutePath() + File.separator + file3.getOriginalFilename());
			    Path path4 = Paths.get(file.getAbsolutePath() + File.separator + file4.getOriginalFilename());
			    
			    
			   Files.copy(inputStream1, path1, StandardCopyOption.REPLACE_EXISTING);
			   Files.copy(inputStream2, path2, StandardCopyOption.REPLACE_EXISTING);
			   Files.copy(inputStream3, path3, StandardCopyOption.REPLACE_EXISTING );
			   Files.copy(inputStream4, path4, StandardCopyOption.REPLACE_EXISTING);
		}
		
		
		
		Product addProduct = productDao.addProduct(product);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	return "redirect:addProduct";	
	
}
//============================================================================== Handler for delete specific product by its id =========================================================================


@GetMapping("/deleteProduct/{id}")
public String deleteProduct(@PathVariable("id") Integer id, Model model) {
    productDao.deleteProduct(id);
    return "redirect:/admin/product";
}
	
}
