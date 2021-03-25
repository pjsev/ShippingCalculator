package com.sample.shippingCalculator.model;

public class ParcelReject implements ParcelType {
	
	final double price = 0;
	final String name = "Reject";
	double weight;
	double volume;
	
	public ParcelReject(double weight, double volume) {
		this.weight = weight;
		this.volume = volume;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double getShippingCost() {
		return -1;
	}

	

}
