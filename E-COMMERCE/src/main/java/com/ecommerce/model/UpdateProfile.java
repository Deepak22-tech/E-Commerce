package com.ecommerce.model;

public class UpdateProfile {

	private String uprofile_name;
	private long uprofile_phone;
	private String uuser_email;
	private String uprofile_locality;
	private String uprofile_city;
	private String uprofile_state;
	private int uprofile_pincode;
	public UpdateProfile(String uprofile_name, long uprofile_phone, String uuser_email, String uprofile_locality,
			String uprofile_city, String uprofile_state, int uprofile_pincode) {
		super();
		this.uprofile_name = uprofile_name;
		this.uprofile_phone = uprofile_phone;
		this.uuser_email = uuser_email;
		this.uprofile_locality = uprofile_locality;
		this.uprofile_city = uprofile_city;
		this.uprofile_state = uprofile_state;
		this.uprofile_pincode = uprofile_pincode;
	}
	public UpdateProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUprofile_name() {
		return uprofile_name;
	}
	public void setUprofile_name(String uprofile_name) {
		this.uprofile_name = uprofile_name;
	}
	public long getUprofile_phone() {
		return uprofile_phone;
	}
	public void setUprofile_phone(long uprofile_phone) {
		this.uprofile_phone = uprofile_phone;
	}
	public String getUuser_email() {
		return uuser_email;
	}
	public void setUuser_email(String uuser_email) {
		this.uuser_email = uuser_email;
	}
	public String getUprofile_locality() {
		return uprofile_locality;
	}
	public void setUprofile_locality(String uprofile_locality) {
		this.uprofile_locality = uprofile_locality;
	}
	public String getUprofile_city() {
		return uprofile_city;
	}
	public void setUprofile_city(String uprofile_city) {
		this.uprofile_city = uprofile_city;
	}
	public String getUprofile_state() {
		return uprofile_state;
	}
	public void setUprofile_state(String uprofile_state) {
		this.uprofile_state = uprofile_state;
	}
	public int getUprofile_pincode() {
		return uprofile_pincode;
	}
	public void setUprofile_pincode(int uprofile_pincode) {
		this.uprofile_pincode = uprofile_pincode;
	}
	
	
}
