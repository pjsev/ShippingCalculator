package com.sample.shippingCalculator.model;

public class ParcelMedium implements ParcelType {

	final double price = 0.04;
	final String name = "Medium Parcel";
	double weight;
	double volume;
	double discount;
	
	public ParcelMedium(double weight, double volume, double discount) {
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
