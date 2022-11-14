package com.amazon.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazon.mobile.entities.MobileStore;

@Repository
public interface MobileStoreRepository  extends JpaRepository<MobileStore, Integer>{

}
