package com.ecommerce.service_dao;

import java.security.Principal;
import java.util.List;

import com.ecommerce.model.PlaceOrderModel;

public interface PlaceOrderDao {
	
	public List<PlaceOrderModel> ordersave(PlaceOrderModel orderModel, Principal principal);

}
