package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecommerce.model.ProfileModel;


public interface ProfileRepo extends JpaRepository<ProfileModel, Integer> {
	
	@Query("select u from ProfileModel u where u.user_email= :user_email")
	public List<ProfileModel> findByEmail(@Param("user_email") String user_email);
	
	@Query("select u from ProfileModel u where u.profile_id= :profile_id")
	public ProfileModel getProfileById(@Param("profile_id") int id);
	
	

}
