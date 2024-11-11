package com.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ecommerce.model.UserModel;
import com.ecommerce.repository.UserRepo;

public class UserServiceDetailImpl implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel userModel=userRepo.findUserByEmail(email);
		if(userModel==null) {
			throw new UsernameNotFoundException("user not found");
		}
		UserDetailImpl userDetailImpl=new UserDetailImpl(userModel);
		
		return userDetailImpl;
	}

}
