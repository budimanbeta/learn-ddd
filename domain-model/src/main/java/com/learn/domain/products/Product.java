package com.learn.domain.products;

import java.math.BigDecimal;

public class Product {
	private String productCode;
	private BigDecimal unitPrice;
	private String description;
	private int noOfUnit;
	
	public Product(String productCode) {
		this.productCode = productCode;
		this.unitPrice = BigDecimal.ZERO;
		this.noOfUnit = 0;
	}
	
	public Product withUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
		return this;
	}
	
	public Product withNoOfUnit(int noOfUnit) {
		this.noOfUnit = noOfUnit;
		return this;
	}
	
	public Product withDescription(String description) {
		this.description = description;
		return this;
	}
	
	
	
	public String getProductCode() {
		return productCode;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public int getNoOfUnit() {
		return noOfUnit;
	}
	public void setNoOfUnit(int noOfUnit) {
		this.noOfUnit = noOfUnit;
	}
}
