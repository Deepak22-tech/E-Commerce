package com.ecommerce.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.CartModel;
import com.ecommerce.model.PlaceOrderModel;
import com.ecommerce.model.ProductModel;
import com.ecommerce.model.ProfileModel;
import com.ecommerce.model.UpdateProfile;
import com.ecommerce.model.UserModel;
import com.ecommerce.repository.CartRepo;
import com.ecommerce.repository.PlaceOrderRepo;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.repository.ProfileRepo;
import com.ecommerce.repository.UserRepo;
import com.ecommerce.service_impl.CartImpl;
import com.ecommerce.service_impl.PlaceOrderImpl;
import com.ecommerce.service_impl.ProductImpl;
import com.ecommerce.service_impl.UserImpl;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	
	@Autowired
	private UserImpl userImpl;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CartImpl cartImpl;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Autowired
	private PlaceOrderImpl placeOrderImpl;
	
	@Autowired
	private PlaceOrderRepo placeOrderRepo;
	

	
	@ModelAttribute
	public void userDetails(Principal principal, Model model) {
		if(principal!=null) {
			String email =	principal.getName();
			UserModel userModel =userRepo.findUserByEmail(email);
			model.addAttribute("user", userModel);
		}
	}
	@ModelAttribute
	public void cartList(Principal principal, Model model) {
		if(principal!=null) {
			List<CartModel> cartList=cartRepo.getByEmail(principal.getName());
			model.addAttribute("clist", cartList);
		}
	}

	@RequestMapping("/index")
	public String index(Model model) {
		List<ProductModel> prodList=productRepo.findAll();
		model.addAttribute("list", prodList);
		return "index";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("userModel", new UserModel());
		return "register";	
	}
	
	@RequestMapping("/registerProcess")
	public String rProcess(@Valid @ModelAttribute UserModel userModel, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "index";
		}else {
			UserModel userModel1=userImpl.saveUser(userModel);
			if(userModel1==null) {
				System.out.println("Registered Unsuccessfully");
			}
			else {
				System.out.println("Registered Successfully");
			}
		return "redirect:index";
		}
		
		
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
		
	}
	
	@RequestMapping("/loginProcess")
	public String loginProcess(@RequestParam("email")String email, @RequestParam("password") String password) {
			
			return "index";
		}
	
	@RequestMapping("/productDetail")
	public String productDetails( @RequestParam("id")int id, Model model) {
		ProductModel details=productRepo.getById(id);
		if(details!=null) {
			model.addAttribute("details", details);
			System.out.println(details);
		}
		return "productDetail";
	}
	
	@RequestMapping("/cart")
	public String cart(@RequestParam("pid")int pid, CartModel cartModel, Principal principal) {
		CartModel cartModel2=cartImpl.cartAdded(pid, cartModel, principal);
		if(cartModel2!=null) {
		
			return "redirect:/Cart";
		}
		else {
		
		return "productDetail";
		}
	}
	
	@RequestMapping("/Cart")
	public String addCart(Principal principal, Model model) {
		
		List<CartModel> cartList=cartRepo.getByEmail(principal.getName());
		model.addAttribute("clist", cartList);
		
		int totalPrice=cartImpl.getTotalPrice(principal.getName());
		model.addAttribute("totalprice", totalPrice);
		
		int actualPrice=cartImpl.getActualPrice(principal.getName());
		model.addAttribute("actualprice", actualPrice);
		
		int discount= actualPrice - totalPrice;
		model.addAttribute("discount", discount);
		
		System.out.println(discount);
		return "cart";
		}
	
	@RequestMapping("/quantityDecrease")
	public String decreaseQuantity(@RequestParam("cid")int id) {
		CartModel cartModel=cartImpl.quantityDecrease(id);
		if(cartModel!=null) {
			return "redirect:/Cart";
		}
		else {
		return "redirect:/index";
		}
		
	}

	@RequestMapping("/quantityIncrease")
	public String increaseQuantity(@RequestParam("cid")int id) {
		CartModel cartModel=cartImpl.quantityIncrease(id);
		if(cartModel!=null) {
			return "redirect:/Cart";
		}else {
			
			return null;
		}
		
	}
	@RequestMapping("/delete")
	public String deleteCart(@RequestParam("id") int id) {
		cartRepo.deleteById(id);
	
		
			return "redirect:/Cart";
	
	}
	
	@RequestMapping("/profile")
	public String profile(ProfileModel profileModel, Model model, Principal principal) {
		List<ProfileModel> list=profileRepo.findByEmail(principal.getName());
		model.addAttribute("list", list);
		//ProfileModel profileModel1=profileRepo.findUserByEmail(principal.getName());
		//model.addAttribute("profilemodel", );
		return "profile";	
	}
	
	@RequestMapping("/profileProcess")
	public String profile(@ModelAttribute("profileModel") ProfileModel profileModel,Principal principal, Model model) {
		ProfileModel profileModel1=userImpl.saveData(profileModel);
		if(profileModel1!=null) {
		return "redirect:/profile";
		}
		else {
			return null;
		}
	}
	
	@RequestMapping("/updateProfile")
	public String updateProfile(@RequestParam("id") int id, Model model) {
		ProfileModel profileModel =	profileRepo.getById(id);
		model.addAttribute("UpdateProfile", profileModel);
		return "updateProfile";
	}
	
	@RequestMapping("/updateprofileProcess")
	public String updateprofileProcess(@RequestParam("id") int id, UpdateProfile updateProfile) {
		ProfileModel profileModel =	userImpl.updateProfile(id, updateProfile);
		if(profileModel!=null) {
			System.out.println("Updated Successfully!!!");
			return "redirect:/profile";
		}	
		return null;
	}
	
	
	@RequestMapping("/buyProduct")
	public String buyProduct() {
		return "buyProduct";
	}
	
	

	@RequestMapping("/placeorder")
	public String placeOrder( Model model, Principal principal) {
		
		
		List<CartModel> cartList=cartRepo.getByEmail(principal.getName());
		model.addAttribute("clist", cartList);
		
		int totalPrice=cartImpl.getTotalPrice(principal.getName());
		model.addAttribute("totalprice", totalPrice);
		int actualPrice=cartImpl.getActualPrice(principal.getName());
		model.addAttribute("actualprice", actualPrice);
		int discount= actualPrice - totalPrice;
		model.addAttribute("discount", discount);
		
		List<ProfileModel> address=profileRepo.findByEmail(principal.getName());
		model.addAttribute("profile", address);
		
		
		
		return "placeOrder";
	}
	
	@RequestMapping("/order")
	public String order(PlaceOrderModel placeOrderModel, Model model, Principal principal) {
		List<PlaceOrderModel> placeOrderModel1=placeOrderImpl.ordersave(placeOrderModel, principal);
		
		if(placeOrderModel1!=null) {
		return "redirect:/paymentdone";
		}
		return null;
	}

	@RequestMapping("/paymentdone")
	public String paymentDone(CartModel cartModel, Principal principal) {
		cartRepo.deleteAll();
		return "paymentDone";
	}
	
	@RequestMapping("/myorder")
	public String myOrder(Principal principal, Model model) {
		List<PlaceOrderModel> myorders=placeOrderRepo.getByEmail(principal.getName());
		model.addAttribute("myorder", myorders);
		return "myOrders";
	}
	@RequestMapping("/allOrders")
	public String allOrder(Model model) {
		List<PlaceOrderModel> orderList=placeOrderRepo.findAll();
		model.addAttribute("olist", orderList);
		return "allOrders";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	

	
	
}
		
		
	

	