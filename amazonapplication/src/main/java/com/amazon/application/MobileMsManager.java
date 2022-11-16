package com.amazon.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.amazon.application.bos.MobilesResponse;

@Component
public class MobileMsManager {
	
	@Autowired
	private DiscoveryManager discoveryManager;
	
	@Autowired
	private RestTemplate restTemplate;

	
	public MobilesResponse getReponseFromMobileMS() {
		List<ServiceInstance> serviceInstances = null;
		String uri = null;
		MobilesResponse response = null;
		serviceInstances = discoveryManager.getServiceInstances("MOBILE-STORE");
		
		/*
		 * ServiceInstance instance = serviceInstances.get(0);
		 * 
		 * uri = instance.getUri()+"/mobiles";
		 */
		
		for(ServiceInstance instance: serviceInstances) {
			
			
			uri = instance.getUri()+"/mobiles";
			System.out.println("URI is :"+uri);
			response = restTemplate.exchange(uri, HttpMethod.GET,null,MobilesResponse.class).getBody();
		}
		
		return response;
				
	}
}
