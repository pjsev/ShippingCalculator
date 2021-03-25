package com.sample.shippingCalculator.model;


public class Voucher {
	
	private String code;
	private double discount;
	private String expiry;
	private String message;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getExpiry() {
		return expiry;
	}
	
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
