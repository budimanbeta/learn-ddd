package com.learn.domain.customers;

import java.util.Objects;

public class Customer {
	
	private String customerNumber;
	
	public Customer() {
		
	}
	
	public Customer(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCustomerNumber() {
		return customerNumber;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(customerNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerNumber, other.customerNumber);
	}
	
	
}

