package com.sample.shippingCalculator.model;

public class ParcelHeavy implements ParcelType {
	
	final double price = 20;
	public final String name = "Heavy Parcel";
	double weight;
	double volume;
	double discount;
	
	public ParcelHeavy(double weight, double volume, double discount) {
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
		double cost = (price * weight) - discount;
		return cost;
	}
	
	
}
