package com.sample.shippingCalculator.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sample.shippingCalculator.model.ItemDetail;
import com.sample.shippingCalculator.model.Voucher;
/**
 * 
 * @author Paolo Antonio J. Severino
 * @version $Id: VoucherCodeService.java 24-03-2021
 *
 */
@Service
public class VoucherCodeService {
	
	@Value("${voucher.api.path}")
	private String voucherPath;
	
	@Value("${voucher.api.key}")
	private String voucherKey;

	public ResponseEntity getVoucherItem(ItemDetail itemDetail) {
		String voucherCode = itemDetail.getVoucher().getCode();
		ResponseEntity<Voucher> response = execute(voucherCode);
		
		return response;
	}
	
	public ResponseEntity execute(String voucherCode) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new APIErrorHandler());
		String resourceUrl = voucherPath + voucherCode + "?key=" + voucherKey;
		ResponseEntity<Voucher> response
		  = restTemplate.getForEntity(resourceUrl, Voucher.class);
		return response;
	}
	
	protected boolean hasVoucherCode(ItemDetail itemDetail) {
		if (itemDetail.getVoucher() != null) {
			return true;
		}
		return false;
	}

}
