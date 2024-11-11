package com.ecommerce.service_impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.model.ProfileModel;
import com.ecommerce.model.UpdateProfile;
import com.ecommerce.model.UserModel;
import com.ecommerce.repository.ProfileRepo;
import com.ecommerce.repository.UserRepo;
import com.ecommerce.service_dao.UserDao;

@Service
public class UserImpl implements UserDao {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ProfileRepo profileRepo;
	
	@Override
	public UserModel saveUser(UserModel userModel) {
		userModel.setPassword(bCryptPasswordEncoder.encode(userModel.getPassword()));
		userModel.setRole("ROLE_USER");
		UserModel userModel2=userRepo.save(userModel);
		
		return userModel2;
	}


	@Override
	public ProfileModel saveData(ProfileModel profileModel) {
	   ProfileModel	profileModel1=profileRepo.save(profileModel);
		return profileModel1;
	}


	@Override
	public ProfileModel updateProfile(int id, UpdateProfile updateProfile) {
		ProfileModel profileModel =profileRepo.getById(id);
		if(profileModel!=null) {
			profileModel.setProfile_name(updateProfile.getUprofile_name());
			profileModel.setUser_email(updateProfile.getUuser_email());
			profileModel.setProfile_phone(updateProfile.getUprofile_phone());
			profileModel.setProfile_locality(updateProfile.getUprofile_locality());
			profileModel.setProfile_city(updateProfile.getUprofile_city());
			profileModel.setProfile_state(updateProfile.getUprofile_state());
			profileModel.setProfile_pincode(updateProfile.getUprofile_pincode());
			profileRepo.save(profileModel);
			return profileModel;
		}else {
		return null;
		}
	}

}
