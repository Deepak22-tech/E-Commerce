package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.ProfileModel;
import com.ecommerce.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{
	
	@Query("select u from UserModel u where u.email=:email")
	public UserModel findUserByEmail(@Param("email") String email);



}
