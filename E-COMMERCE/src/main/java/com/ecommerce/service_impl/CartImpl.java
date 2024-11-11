package com.ecommerce.service_impl;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.model.CartModel;
import com.ecommerce.model.ProductModel;
import com.ecommerce.repository.CartRepo;
import com.ecommerce.repository.ProductRepo;
import com.ecommerce.service_dao.CartDao;


@Service
public class CartImpl implements CartDao{
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private ProductRepo productRepo;


	@Override
	public CartModel cartAdded(int id,CartModel cartModel, Principal principal) {
		ProductModel cartItem=productRepo.getById(id);
		int totalprice=cartItem.getProd_price() * 1;
		int discount= cartItem.getProd_actualprice() - cartItem.getProd_price(); 
		CartModel cart=new CartModel(id, cartItem.getProd_name(), principal.getName(), 1, cartItem.getProd_price(),cartItem.getProd_actualprice(), totalprice, discount, cartItem.getProd_image(), cartItem.getProd_category());
		CartModel cartModel2=cartRepo.save(cart);	
		if(cartModel2!=null) {
			System.out.println("Item Added to Cart Successfully");
			return cart;
		}else {
			System.out.println("Item Not Added to Cart");
		return null;
		}
}

	@Override
	public CartModel quantityIncrease(int id) {
		CartModel cartModel=cartRepo.getById(id);
		if(cartModel!=null) {
			int quantity=cartModel.getCart_quantity();
			quantity+=1;
			cartModel.setCart_quantity(quantity);
			int price= cartModel.getCart_price();
			int Price= price*quantity;
			cartModel.setTotal_price(Price);
			
			cartRepo.save(cartModel);
			return cartModel;
		}
		else {
		return null;
		}
	}


	@Override
	public CartModel quantityDecrease(int id) {
		CartModel cartModel=cartRepo.getById(id);
		try {
			
		
		if(cartModel!=null) {
			int quantity=cartModel.getCart_quantity();
			quantity-=1;
			  if (quantity < 1) {
		            // Delete the item from the cart if quantity is less than 1
		            cartRepo.delete(cartModel);
		            System.out.println("deleted");
		            return null; // Item has been deleted
		       
			  }
			  System.out.println("not");
			cartModel.setCart_quantity(quantity);
			int price=cartModel.getCart_price();
			int Price=price * quantity;
			cartModel.setTotal_price(Price);
			cartRepo.save(cartModel);
			return cartModel;
		}
		} catch (Exception e) {
			e.getMessage();
		}
		
		return null;
		
	}

	@Override
	public int getTotalPrice(String email) {
		// TODO Auto-generated method stub
		int totalPrice=cartRepo.getTotalPrice(email);
		return totalPrice;
	}

	@Override
	public int getActualPrice(String email) {
		// TODO Auto-generated method stub
		int actualPrice=cartRepo.getActualPrice(email);
		return actualPrice;
	}
	
	
	
}
