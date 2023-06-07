package com.learn.domain.orders;

import com.learn.domain.customers.Customer;

public class OrderFactory {

	public static Order createOrder(Customer customer) {
		return new Order(customer);
	}
	
	public static Order createOrder(String customerNumber, String orderNumber) {
		Order order = new Order(customerNumber, orderNumber);
		return order;
	}
	
	

}
