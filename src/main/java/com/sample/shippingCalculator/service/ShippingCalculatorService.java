package com.sample.shippingCalculator.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sample.shippingCalculator.commons.CalculationUtil;
import com.sample.shippingCalculator.commons.ValueConditionConstants;
import com.sample.shippingCalculator.model.ItemDetail;
import com.sample.shippingCalculator.model.ParcelHeavy;
import com.sample.shippingCalculator.model.ParcelReject;
import com.sample.shippingCalculator.model.ParcelLarge;
import com.sample.shippingCalculator.model.ParcelMedium;
import com.sample.shippingCalculator.model.ParcelSmall;
import com.sample.shippingCalculator.model.ParcelType;
/**
 * 
 * @author Paolo Antonio J. Severino
 * @version $Id: ShippingCalculatorService.java 24-03-2021
 *
 */
@Service
public class ShippingCalculatorService {
	
	@Autowired
	VoucherCodeService voucherCodeService;
	
	public ResponseEntity<ItemDetail> calculate(ItemDetail itemDetail) {	
		double volume = CalculationUtil.getVolume(itemDetail.getHeight(), itemDetail.getWidth(),
				itemDetail.getLength());
		itemDetail.setVolume(volume);
		
		ParcelType parcelType = getParcelType(itemDetail); 
		itemDetail.setParcelType(parcelType);
		 	
		return ResponseEntity.ok().body(itemDetail);
	}	

	public ParcelType getParcelType(ItemDetail itemDetail) {
		double weight = itemDetail.getWeight();
		double volume = itemDetail.getVolume();
		
		double discount = 0;
		if (voucherCodeService.hasVoucherCode(itemDetail)) {
			discount = itemDetail.getVoucher().getDiscount();
		}
		if (itemDetail.getWeight() > ValueConditionConstants.maxWeight) {
			return new ParcelReject(weight, volume);
		} else if (itemDetail.getWeight() > ValueConditionConstants.minHeavyWeight) {
			return new ParcelHeavy(weight, volume, discount);
		} else if (itemDetail.getVolume() < ValueConditionConstants.maxSmallVolume) {
			return new ParcelSmall(weight, volume, discount);
		} else if (itemDetail.getVolume() < ValueConditionConstants.maxMediumVolume) {
			return new ParcelMedium(weight, volume, discount);
		} else if (itemDetail.getVolume() > ValueConditionConstants.maxMediumVolume
				&& itemDetail.getWeight() < ValueConditionConstants.maxWeight) {
			return new ParcelLarge(weight, volume, discount);
		} 
		return null;		
	}
}
