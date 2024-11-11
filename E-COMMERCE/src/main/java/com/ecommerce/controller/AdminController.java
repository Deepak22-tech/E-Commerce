package com.ecommerce.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.model.CartModel;
import com.ecommerce.model.ProductModel;
import com.ecommerce.model.ProfileModel;
import com.ecommerce.model.UpdateProduct;
import com.ecommerce.model.UpdateProfile;
import com.ecommerce.model.UserModel;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.repository.UserRepo;
import com.ecommerce.service_impl.ProductImpl;
import com.ecommerce.service_impl.UserImpl;

@Controller
public class AdminController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductImpl productImpl;
	

	@ModelAttribute
	public void userDetails(Principal principal, Model model) {
		if(principal!=null) {
			String email =	principal.getName();
			UserModel userModel =userRepo.findUserByEmail(email);
			model.addAttribute("user", userModel);
			
			List<ProductModel> product=productRepo.findAll();
			model.addAttribute("product", product);
			}
	}
	
	
	
	@RequestMapping("/addProduct")
	public String product(Model model) {
		model.addAttribute("product", new ProductModel());
		return "addProduct";	
		}
	
	@RequestMapping("/productProcess")
	public String addProduct(@ModelAttribute ProductModel prodModel,@RequestParam ("productimage")MultipartFile pimage,@RequestParam ("productimage1")MultipartFile pimage1,@RequestParam ("productimage2")MultipartFile pimage2,@RequestParam ("productimage3")MultipartFile pimage3,@RequestParam ("productimage4")MultipartFile pimage4, Model model) {
		ProductModel productModel=productImpl.saveProduct(prodModel, pimage, pimage1, pimage2, pimage3, pimage4 );
		if(productModel!=null) {
			model.addAttribute("product", productModel);
			System.out.println(productModel);
			List<ProductModel> prodList=productRepo.findAll();
			model.addAttribute("list", prodList);
			return "redirect:index";
		}
		else {
		return "adminHome";
		}
	}
	@RequestMapping("/productList")
	public String productList(Model model) {
		List<ProductModel> prodList=productRepo.findAll();
		model.addAttribute("plist", prodList);
		
		return "productList";
	}
	
	@RequestMapping("/userList")
	public String userList(Model model) {
		List<UserModel> userList=userRepo.findAll();
		model.addAttribute("ulist", userList);
		
		return "userList";
	}
	
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@RequestParam("id")int id,UpdateProduct updateProduct, Model model) {
		ProductModel productModel=productRepo.getById(id);
		model.addAttribute("updateProduct", productModel);
		
		return "updateProduct";
	}
	@RequestMapping("/updateProductProcess")
	public String updateProductProcess(@RequestParam("id") int id, UpdateProduct updateProduct,@RequestParam ("uproductimage")MultipartFile upimage,@RequestParam ("uproductimage1")MultipartFile upimage1,@RequestParam ("uproductimage2")MultipartFile upimage2,@RequestParam ("uproductimage3")MultipartFile upimage3,@RequestParam ("uproductimage4")MultipartFile upimage4, Model model) {
		ProductModel productModel=productImpl.updateProduct(id, updateProduct, upimage, upimage1, upimage2, upimage3, upimage4);
		if(productModel!=null) {
			System.out.println("Updated Successfully!!!");
			return "redirect:/productList";
		}	
		return null;
	}

	
	
	@RequestMapping("/adminHome")
	public String adminHome() {
		return "adminHome";
	}
	

}
