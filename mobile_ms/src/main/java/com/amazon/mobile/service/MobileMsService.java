package com.amazon.mobile.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazon.mobile.bos.MobileStoreBo;
import com.amazon.mobile.entities.MobileStore;
import com.amazon.mobile.repository.MobileStoreRepository;

@Service
public class MobileMsService {

	@Autowired
	private MobileStoreRepository repository;

	@Transactional(readOnly = true)
	public List<MobileStore> getMobileFromService() {
		return repository.findAll();
	}

	@Transactional
	public String addMobile(MobileStoreBo request) {
		
		MobileStore mobileStore = new MobileStore();
		BeanUtils.copyProperties(request, mobileStore);
		
		repository.save(mobileStore);
		return "Mobile Added Successfully";
	}

}
