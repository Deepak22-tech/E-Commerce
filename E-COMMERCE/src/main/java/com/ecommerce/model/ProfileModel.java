package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProfileModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profile_id;
	private String profile_name;
	private long profile_phone;
	private String user_email;
	private String profile_locality;
	private String profile_city;
	private String profile_state;
	private int profile_pincode;
	
	public ProfileModel(int profile_id, String profile_name, long profile_phone, String user_email, String profile_locality, String profile_city,
			String profile_state, int profile_pincode) {
		super();
		this.profile_id=profile_id;
		this.profile_name = profile_name;
		this.profile_phone = profile_phone;
		this.user_email=user_email;
		this.profile_locality = profile_locality;
		this.profile_city = profile_city;
		this.profile_state = profile_state;
		this.profile_pincode = profile_pincode;
	}
	public ProfileModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getProfile_name() {
		return profile_name;
	}
	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	public long getProfile_phone() {
		return profile_phone;
	}
	public void setProfile_phone(long profile_phone) {
		this.profile_phone = profile_phone;
	}
	public String getProfile_locality() {
		return profile_locality;
	}
	public void setProfile_locality(String profile_locality) {
		this.profile_locality = profile_locality;
	}
	public String getProfile_city() {
		return profile_city;
	}
	public void setProfile_city(String profile_city) {
		this.profile_city = profile_city;
	}
	public String getProfile_state() {
		return profile_state;
	}
	public void setProfile_state(String profile_state) {
		this.profile_state = profile_state;
	}
	public int getProfile_pincode() {
		return profile_pincode;
	}
	public void setProfile_pincode(int profile_pincode) {
		this.profile_pincode = profile_pincode;
	}
	@Override
	public String toString() {
		return "ProfileModel [profile_name=" + profile_name + ", profile_phone=" + profile_phone + ", user_email="
				+ user_email + ", profile_locality=" + profile_locality + ", profile_city=" + profile_city
				+ ", profile_state=" + profile_state + ", profile_pincode=" + profile_pincode + "]";
	}
	
	
	
	

}
