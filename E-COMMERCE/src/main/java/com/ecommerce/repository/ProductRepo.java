package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.ProductModel;

public interface ProductRepo extends JpaRepository<ProductModel, Integer>{

	@Query("select r from ProductModel r where r.prod_id= :prod_id")
	public List<ProductModel> getProductById(@Param("prod_id") int id);
}
