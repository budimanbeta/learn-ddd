package com.learn.domain.orders;

import java.util.List;

import com.learn.domain.commons.persistence.Workspace;
import com.learn.domain.commons.persistence.WorkspaceException;
import com.learn.domain.customers.Customer;
import com.learn.domain.orders.finder.OrderFinder;

public class OrderRepository {
	private Workspace<Order> orderWorkspace;
	private OrderFinder orderFinder;
	public OrderRepository(Workspace<Order> orderWorkspace, OrderFinder orderFinder) {
		this.orderWorkspace = orderWorkspace;
		this.orderFinder = orderFinder;
	}
	
	public void addOrder(Order order) {
		try {
			orderWorkspace.makePersistence(order);
			orderWorkspace.persistAll();
		} catch (WorkspaceException e) {
			e.printStackTrace();
		}
	
	}
	public Order getOrder(String orderNumber) {
		try {
			return orderWorkspace.getById(orderNumber);
		} catch (WorkspaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Order> getOrders(Customer customer){
		return orderFinder.findByCustomerNumber(customer.getCustomerNumber());
	}
	
	
}
