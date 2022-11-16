package com.amazon.application.bos;

import java.util.List;


import lombok.Data;

@Data
public class MobilesResponse {
	private String vendor;
	private List<MobileStore> mobileStores;
}
