package com.sample.shippingCalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sample.shippingCalculator.model.ItemDetail;
import com.sample.shippingCalculator.model.Voucher;
import com.sample.shippingCalculator.service.ShippingCalculatorService;
import com.sample.shippingCalculator.service.VoucherCodeService;
/**
 * 
 * @author Paolo Antonio J. Severino
 * @version $Id: ShippingCalcController.java 24-03-2021
 *
 */
@RestController
public class ShippingCalcController {
	
	@Autowired
	private ShippingCalculatorService shippingCalculatorService;
	
	@Autowired
	private VoucherCodeService voucherCodeService;
	
	/*
	 * Calculates given weight, height, width and length in json format
	 * returns ItemDetail object
	 */
	@PostMapping("/calculate")
	@ResponseBody
	public ResponseEntity<ItemDetail> calculateShipping(@RequestBody ItemDetail itemDetail) throws JsonMappingException,
		JsonProcessingException {
		
		if (itemDetail.getVoucher() != null) {
			ResponseEntity<Voucher> response = voucherCodeService.getVoucherItem(itemDetail);
			if (response.getStatusCode() == HttpStatus.OK) {
				itemDetail.getVoucher().setDiscount(response.getBody().getDiscount());
				itemDetail.getVoucher().setExpiry(response.getBody().getExpiry());
			} else {
				itemDetail.getVoucher().setMessage("Invalid Voucher Code.");
			}
		}
		ResponseEntity<ItemDetail> shippingCost = shippingCalculatorService.calculate(itemDetail);
		
		return shippingCost;
	}
	

}
