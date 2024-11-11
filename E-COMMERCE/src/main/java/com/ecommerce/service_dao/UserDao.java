package com.ecommerce.service_dao;

import java.security.Principal;

import com.ecommerce.model.ProfileModel;
import com.ecommerce.model.UpdateProfile;
import com.ecommerce.model.UserModel;

public interface UserDao {

	
	public UserModel saveUser(UserModel userModel);
	public ProfileModel saveData(ProfileModel profileModel);
	public ProfileModel updateProfile(int id, UpdateProfile updateProfile);

}
