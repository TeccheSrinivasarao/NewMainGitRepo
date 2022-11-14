package com.amazon.mobile.bos;

import java.util.List;

import com.amazon.mobile.entities.MobileStore;

import lombok.Data;

@Data
public class MobilesResponse {
	private String vendor;
	private List<MobileStore> mobileStores;
	
}
