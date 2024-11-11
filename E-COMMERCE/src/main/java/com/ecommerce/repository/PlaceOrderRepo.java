package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.PlaceOrderModel;

public interface PlaceOrderRepo extends JpaRepository<PlaceOrderModel, Integer>{

	@Query("select o from PlaceOrderModel o where o.uemail= :uemail")
	public List<PlaceOrderModel> getByEmail(@Param("uemail") String uemail);
	
}
