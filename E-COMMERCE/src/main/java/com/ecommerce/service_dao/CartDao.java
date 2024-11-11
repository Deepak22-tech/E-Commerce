package com.ecommerce.service_dao;

import java.security.Principal;

import com.ecommerce.model.CartModel;

public interface CartDao {
	
	public CartModel cartAdded(int id, CartModel cartModel, Principal principal);
	public CartModel quantityIncrease(int id);
	public CartModel quantityDecrease(int id);
	public int getTotalPrice(String email);
	public int getActualPrice(String email);
}
