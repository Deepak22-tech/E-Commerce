package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.CartModel;


public interface CartRepo extends JpaRepository<CartModel, Integer>{

	@Query("select c from CartModel c where c.cart_id= :cart_id")
	public CartModel getProductById(@Param("cart_id") int cart_id);
	
	@Query("select c from CartModel c where c.user_email= :user_email")
	public List<CartModel> getByEmail(@Param("user_email") String user_email);
	
	@Query("select sum(c.total_price) from CartModel c where c.user_email= :user_email")
	public int getTotalPrice(@Param("user_email") String user_email);
	
	@Query("select sum(c.cart_actualPrice * c.cart_quantity) from CartModel c where c.user_email= :user_email")
	public int getActualPrice(@Param("user_email") String user_email);
	
	@Query("delete from CartModel c where c.user_email= :user_email")
	void deleteCart(@Param("user_email") String user_email);
	
}
