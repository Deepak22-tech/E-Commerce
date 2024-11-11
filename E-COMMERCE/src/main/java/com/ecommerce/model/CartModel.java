package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cart_id;
	private int prod_id;
	private String cart_name;
	private String user_email;
	private int cart_quantity;
	private int total_price;
	private int cart_price;
	private int cart_actualPrice;
	private int cart_discount;
	private String cart_image;
	private String cart_category;
	public CartModel( int prod_id, String cart_name, String user_email, int cart_quantity, int cart_price,int cart_actualPrice,
			int total_price,int cart_discount, String cart_image, String cart_category) {
		super();
		
		this.prod_id = prod_id;
		this.cart_name = cart_name;
		this.user_email = user_email;
		this.cart_quantity = cart_quantity;
		this.total_price = total_price;
		this.cart_price = cart_price;
		this.cart_actualPrice=cart_actualPrice;
		this.cart_discount=cart_discount;
		this.cart_image = cart_image;
		this.cart_category = cart_category;
	}
	public int getCart_actualPrice() {
		return cart_actualPrice;
	}
	public void setCart_actualPrice(int cart_actalPrice) {
		this.cart_actualPrice = cart_actalPrice;
	}
	public CartModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getCart_discount() {
		return cart_discount;
	}
	public void setCart_discount(int cart_discount) {
		this.cart_discount = cart_discount;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getCart_name() {
		return cart_name;
	}
	public void setCart_name(String cart_name) {
		this.cart_name = cart_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getCart_price() {
		return cart_price;
	}
	public void setCart_price(int cart_price) {
		this.cart_price = cart_price;
	}
	public String getCart_image() {
		return cart_image;
	}
	public void setCart_image(String cart_image) {
		this.cart_image = cart_image;
	}
	public String getCart_category() {
		return cart_category;
	}
	public void setCart_category(String cart_category) {
		this.cart_category = cart_category;
	}
	@Override
	public String toString() {
		return "CartModel [cart_id=" + cart_id + ", prod_id=" + prod_id + ", cart_name=" + cart_name + ", user_email="
				+ user_email + ", cart_quantity=" + cart_quantity + ", total_price=" + total_price + ", cart_price="
				+ cart_price + ", cart_actualPrice=" + cart_actualPrice + ", cart_discount=" + cart_discount
				+ ", cart_image=" + cart_image + ", cart_category=" + cart_category + "]";
	}

	
}