package com.amazon.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryManager {

	@Autowired
	private DiscoveryClient discoveryClient;

	public List<ServiceInstance> getServiceInstances(String microServiceName) {

		return discoveryClient.getInstances(microServiceName);
	}

}
