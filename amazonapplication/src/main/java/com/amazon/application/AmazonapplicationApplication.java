package com.amazon.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.amazon.application.bos.MobileStore;
import com.amazon.application.bos.MobilesResponse;

@SpringBootApplication
@EnableDiscoveryClient
public class AmazonapplicationApplication {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AmazonapplicationApplication.class, args);
		MobileMsManager mobileMsManager = applicationContext.getBean(MobileMsManager.class);
		MobilesResponse mobilesResponse = mobileMsManager.getReponseFromMobileMS();
		System.out.println(mobilesResponse.toString());
		for(MobileStore response: mobilesResponse.getMobileStores()) {
			
			response.setPrice(response.getPrice()+new Double("1000"));
			
		}
		
		System.out.println(mobilesResponse.toString());
	}

}
