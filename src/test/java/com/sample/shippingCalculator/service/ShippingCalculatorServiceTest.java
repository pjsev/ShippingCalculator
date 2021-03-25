package com.sample.shippingCalculator.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.shippingCalculator.commons.CalculationUtil;
import com.sample.shippingCalculator.model.ItemDetail;
import com.sample.shippingCalculator.model.ParcelType;
import com.sample.shippingCalculator.model.Voucher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShippingCalculatorServiceTest {

	@Autowired
    private ShippingCalculatorService shippingCalculatorService;
	
	ItemDetail itemDetail;
	Voucher voucher;
	
	@Test
	public void testParcelType() {
				
		givenTheFollowingDimensions(20, 10, 10, 10);
		assertThatTheParcelTypeIsCorrect(itemDetail, "Heavy Parcel");
		
		givenTheFollowingDimensions(51, 10, 10, 10);
		assertThatTheParcelTypeIsCorrect(itemDetail, "Reject");
		
		givenTheFollowingDimensions(5, 10, 10, 2);
		assertThatTheParcelTypeIsCorrect(itemDetail, "Small Parcel");
		
		givenTheFollowingDimensions(5, 100, 10, 2);
		assertThatTheParcelTypeIsCorrect(itemDetail, "Medium Parcel");
		
		givenTheFollowingDimensions(5, 100, 100, 20);
		assertThatTheParcelTypeIsCorrect(itemDetail, "Large Parcel");
		
	}
	
	@Test
	public void testShippingCost() {
		givenTheFollowingDimensions(5, 10, 10, 2);
		ParcelType type = shippingCalculatorService.getParcelType(itemDetail);
		assertThatTheCostIsCorrect("Small Parcel", 0.3, type);
	}
	
	@Test
	public void testShippingCostVithVoucher() {
		givenTheFollowingDimensions(8, 50, 50, 2);
		givenAVoucherCode();
		ParcelType type = shippingCalculatorService.getParcelType(itemDetail);
		assertThatDiscountIsApplied("Large Parcel", type, itemDetail.getVoucher().getDiscount());
	}
	
	

	private void assertThatDiscountIsApplied(String string, ParcelType type, double discount) {
		double volume = itemDetail.getVolume();
		double price = type.getPrice();
		double cost = (price * volume) - discount;
		assertEquals(String.valueOf(type.getShippingCost()), String.valueOf(cost));
	}

	private void assertThatTheCostIsCorrect(String string, double d, ParcelType type) {
		double volume = itemDetail.getVolume();
		double price = type.getPrice();
		double cost = price * volume;
		assertEquals(String.valueOf(type.getShippingCost()), String.valueOf(cost));
	}

	private void assertThatTheParcelTypeIsCorrect(ItemDetail itemDetail, String typeName) {
		ParcelType type = shippingCalculatorService.getParcelType(itemDetail);
		assertEquals(typeName, type.getName());
	}

	private void givenTheFollowingDimensions(double weight, double height, double width, double length) {
		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setWeight(weight);
		itemDetail.setHeight(height);
		itemDetail.setWidth(width);
		itemDetail.setLength(length);
		double volume = CalculationUtil.getVolume(itemDetail.getHeight(), itemDetail.getWidth(),
				itemDetail.getLength());
		itemDetail.setVolume(volume);
		
		this.itemDetail = itemDetail;
	}
	
	private void givenAVoucherCode() {
		Voucher voucher = new Voucher();
		voucher.setCode("MYNT");	
		voucher.setDiscount(5);
		itemDetail.setVoucher(voucher);
	}
	
	
}
