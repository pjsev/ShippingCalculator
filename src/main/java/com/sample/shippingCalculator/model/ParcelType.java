package com.sample.shippingCalculator.model;

public interface ParcelType {
	/*
	 * Parcel Type data ideally should be stored in DB.
	 */
	String getName();
	double getPrice();
	double getShippingCost();
}
