package com.amazon.mobile.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "mobile_store")
@Data
public class MobileStore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "brand_name")
	private String brandName;
	
	private String version;
	
	private String color;
	
	private String ram;
	
	private String storage;
	
	private double price;
	

	
}
