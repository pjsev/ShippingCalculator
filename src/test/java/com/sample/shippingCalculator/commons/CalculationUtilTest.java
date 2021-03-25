package com.sample.shippingCalculator.commons;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sample.shippingCalculator.commons.CalculationUtil;

public class CalculationUtilTest {
	
	private double height;
	private double width;
	private double length;
	
	@BeforeEach
	public void setUp() throws Exception {
		this.createSampleDimensions();
		
	}
	
	public void createSampleDimensions() {
		this.height = 2;
		width = 2;
		length = 2;		
	}

	@Test
	public void getVolume() {
		assertEquals(8, CalculationUtil.getVolume(height, width, length));
	}

}
