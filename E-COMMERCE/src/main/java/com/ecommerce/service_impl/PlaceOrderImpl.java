package com.ecommerce.service_impl;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.ecommerce.model.CartModel;
import com.ecommerce.model.PlaceOrderModel;
import com.ecommerce.repository.CartRepo;
import com.ecommerce.repository.PlaceOrderRepo;
import com.ecommerce.service_dao.PlaceOrderDao;

@Service
public class PlaceOrderImpl implements PlaceOrderDao{
	
	@Autowired
	private PlaceOrderRepo placeOrderRepo;
	
	@Autowired
	private CartRepo cartRepo;
	

	@Override
	public List<PlaceOrderModel> ordersave(PlaceOrderModel orderModel, Principal principal) {
	    List<CartModel> orderItems = cartRepo.getByEmail(principal.getName());
	    List<PlaceOrderModel> savedOrders = new ArrayList<>();
	    
	    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    String currentDate = dtf.format(LocalDateTime.now());
	    String userEmail = principal.getName();
	    String orderStatus = "processing...";
	    
	    for (CartModel cartItem : orderItems) {
	        PlaceOrderModel placeOrder = new PlaceOrderModel();
	        placeOrder.setPname(cartItem.getCart_name());
	        placeOrder.setPquantity(cartItem.getCart_quantity());
	        placeOrder.setTotalprice(cartItem.getTotal_price());
	        placeOrder.setStatus(orderStatus);
	        placeOrder.setOdate(currentDate);
	        placeOrder.setUemail(userEmail);
	        placeOrder.setPimage(cartItem.getCart_image());
	        
	        placeOrderRepo.save(placeOrder);
	        savedOrders.add(placeOrder);
	    }
	    return savedOrders;
	}


}
