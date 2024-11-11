package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prod_id;
	private String prod_name;
	private int prod_quantity;
	private String prod_desc;
	private int prod_price;
	private int prod_actualprice;
	private int prod_discount;
	private String prod_image;
	private String prod_image1;
	private String prod_image2;
	private String prod_image3;
	private String prod_image4;
	private String prod_category;
	
	public ProductModel(int prod_id, String prod_name, String prod_desc, int prod_quantity, int prod_price, int prod_actualprice,
			String prod_category, int prod_discount,  String prod_image,String prod_image1,String prod_image2,String prod_image3,String prod_image4) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_desc = prod_desc;
		this.prod_quantity=prod_quantity;
		this.prod_price = prod_price;
		this.prod_actualprice = prod_actualprice;
		this.prod_category = prod_category;
		this.prod_discount = prod_discount;
		this.prod_image = prod_image;
		this.prod_image1 = prod_image1;
		this.prod_image2 = prod_image2;
		this.prod_image3 = prod_image3;
		this.prod_image4 = prod_image4;
	}
	

	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getProd_image1() {
		return prod_image1;
	}


	public void setProd_image1(String prod_image1) {
		this.prod_image1 = prod_image1;
	}


	public String getProd_image2() {
		return prod_image2;
	}


	public void setProd_image2(String prod_image2) {
		this.prod_image2 = prod_image2;
	}


	public String getProd_image3() {
		return prod_image3;
	}


	public void setProd_image3(String prod_image3) {
		this.prod_image3 = prod_image3;
	}


	public String getProd_image4() {
		return prod_image4;
	}


	public void setProd_image4(String prod_image4) {
		this.prod_image4 = prod_image4;
	}


	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_desc() {
		return prod_desc;
	}
	public void setProd_desc(String prod_desc) {
		this.prod_desc = prod_desc;
	}
	public int getProd_quantity() {
		return prod_quantity;
	}
	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_actualprice() {
		return prod_actualprice;
	}
	public void setProd_actualprice(int prod_actualprice) {
		this.prod_actualprice = prod_actualprice;
	}
	public int getProd_discount() {
		return prod_discount;
	}
	public void setProd_discount(int prod_discount) {
		this.prod_discount = prod_discount;
	}
	public String getProd_category() {
		return prod_category;
	}
	public void setProd_category(String prod_category) {
		this.prod_category = prod_category;
	}
	public String getProd_image() {
		return prod_image;
	}
	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}


	@Override
	public String toString() {
		return "ProductModel [prod_id=" + prod_id + ", prod_name=" + prod_name + ", prod_quantity=" + prod_quantity
				+ ", prod_desc=" + prod_desc + ", prod_price=" + prod_price + ", prod_actualprice=" + prod_actualprice
				+ ", prod_discount=" + prod_discount + ", prod_image=" + prod_image + ", prod_image1=" + prod_image1
				+ ", prod_image2=" + prod_image2 + ", prod_image3=" + prod_image3 + ", prod_image4=" + prod_image4
				+ ", prod_category=" + prod_category + "]";
	}



	

	

}
