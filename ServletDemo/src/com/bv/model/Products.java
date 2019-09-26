package com.bv.model;

import java.util.Date;

public class Products {

	private int id;
	private String manufacturername,productname;
	private double price;
	private Date manufracturingDate;
	
	public Date getManufracturingDate() {
		return manufracturingDate;
	}
	public void setManufracturingDate(Date manufracturingDate) {
		this.manufracturingDate = manufracturingDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManufacturername() {
		return manufacturername;
	}
	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
