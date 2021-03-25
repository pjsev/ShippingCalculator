package com.sample.shippingCalculator.model;

public class ParcelSmall implements ParcelType {
	
	final double price = 0.03;
	final String name = "Small Parcel";
	double weight;
	double volume;
	double discount;
	
	public ParcelSmall(double weight, double volume, double discount) {
		this.weight = weight;
		this.volume = volume;
		this.discount = discount;
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
		double cost = (price * volume) - discount;	
		return cost;
	}

	

}
