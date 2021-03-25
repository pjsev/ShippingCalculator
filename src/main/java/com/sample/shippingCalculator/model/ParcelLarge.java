package com.sample.shippingCalculator.model;

public class ParcelLarge implements ParcelType {

	final double price = 0.05;
	final String name = "Large Parcel";
	double weight;
	double volume;
	double discount;
	
	public ParcelLarge(double weight, double volume, double discount) {
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
