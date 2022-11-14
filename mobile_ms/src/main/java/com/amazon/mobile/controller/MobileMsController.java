package com.amazon.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.mobile.bos.MobileStoreBo;
import com.amazon.mobile.bos.MobilesResponse;
import com.amazon.mobile.entities.MobileStore;
import com.amazon.mobile.service.MobileMsService;

import lombok.Data;

@RestController
//@ConfigurationProperties(prefix = "mobilestore")
@Data
@RefreshScope
public class MobileMsController {

	@Autowired
	private MobileMsService service;
	
	@Value("${mobilestore.vendor-name}")
	private String vendorName;

	@GetMapping(path = "/mobiles")
	public MobilesResponse getMobilesFromStore() {

		MobilesResponse mobilesResponse= new MobilesResponse();
		List<MobileStore> mobiles = service.getMobileFromService();
		mobilesResponse.setMobileStores(mobiles);
		mobilesResponse.setVendor(vendorName);

		return mobilesResponse;
	}

	@PostMapping(path = "/addMobiles")
	public String addMobile(@RequestBody MobileStoreBo request) {

		String response = service.addMobile(request);

		return response;
	}

}
