package com.sample.shippingCalculator.model;

public class ItemDetail {
	
	private double weight;
	private double height;
	private double width;
	private double length;
	
	private Voucher voucher;
	
	private double volume;
	private ParcelType parcelType;
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}

	public ParcelType getParcelType() {
		return parcelType;
	}

	public void setParcelType(ParcelType parcelType) {
		this.parcelType = parcelType;
	}
		
	
}
