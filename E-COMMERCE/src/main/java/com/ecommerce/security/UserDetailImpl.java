package com.ecommerce.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.model.UserModel;


public class UserDetailImpl  implements UserDetails{
	
	@Autowired
	private UserModel userModel;

	
	public UserDetailImpl(UserModel userModel) {
		super();
		this.userModel=userModel;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(userModel.getRole());
		
		return List.of(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userModel.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userModel.getEmail();
	}

}
