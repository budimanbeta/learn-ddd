package com.learn.domain.test;

import com.learn.domain.commons.persistence.Workspace;
import com.learn.domain.customers.Customer;
import com.learn.domain.orders.Order;
import com.learn.domain.orders.OrderFactory;
import com.learn.domain.orders.OrderLine;
import com.learn.domain.orders.OrderRepository;
import com.learn.domain.products.Product;

public class CreateNewOrderTest {

	public static void main(String[] args) {
		Order order = OrderFactory.createOrder(new Customer("CA123"));
		Product product1 = new Product("P001");
		Product product2 = new Product("P002");
		order.addOrderLine(new OrderLine(product1));
		order.addOrderLine(new OrderLine(product2));
		
	
		OrderRepository orderRepo = new OrderRepository(new OrderWorkspace(), null);
		orderRepo.addOrder(order);
		
		Order retrieveOrder = orderRepo.getOrder("001");
		
		System.out.println(retrieveOrder.getCustomer().getCustomerNumber());
		for(OrderLine line : retrieveOrder.getOrderLines()) {
			System.out.println(line.getProduct().getProductCode());
		}
		

	}
	
	private static class OrderWorkspace implements Workspace<Order>{

		@Override
		public void persistAll() {
			System.out.println("Commited");
			
		}
		
		@Override
		public void makePersistence(Order entity) {
			System.out.println("order" + entity.getOrderNumber()+"persisted");
			
		}
		
		@Override
		public Order getById(String idValue) {
			Order order = OrderFactory.createOrder(new Customer("CA123"));
			Product product1 = new Product("P001");
			Product product2 = new Product("P002");
			order.addOrderLine(new OrderLine(product1));
			order.addOrderLine(new OrderLine(product2));
			
			// TODO Auto-generated method stub
			return order;
		}
		
	}

}
