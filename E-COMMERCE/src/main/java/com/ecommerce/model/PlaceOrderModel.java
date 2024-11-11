package com.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PlaceOrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;
	private String pname;
	private int pquantity;
	private int totalprice;
	private String status;
	private String odate;
	private String uemail;
	private String pimage;
	public PlaceOrderModel( String pname, int pquantity, int totalprice, String status, String odate, String uemail,
			String pimage) {
		super();
		
		this.pname = pname;
		this.pquantity = pquantity;
		this.totalprice = totalprice;
		this.status = status;
		this.odate = odate;
		this.uemail = uemail;
		this.pimage = pimage;
	}
	public PlaceOrderModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	@Override
	public String toString() {
		return "PlaceOrder [oid=" + oid + ", pname=" + pname + ", pquantity=" + pquantity + ", totalprice=" + totalprice
				+ ", status=" + status + ", odate=" + odate + ", uemail=" + uemail + ", pimage=" + pimage + "]";
	}
	
	
	
}
