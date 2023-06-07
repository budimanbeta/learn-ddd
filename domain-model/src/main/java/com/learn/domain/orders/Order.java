package com.learn.domain.orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.learn.domain.commons.concept.AggregateRoot;
import com.learn.domain.customers.Customer;
import com.learn.domain.orders.value.OrderStatus;
import com.learn.domain.orders.value.OrderType;

public class Order implements AggregateRoot{
	
	private  Customer customer;
	
	private Long id;
	private String orderNumber;
	private LocalDateTime  orderDate;
	private List<OrderLine> orderLines;
	private OrderType orderType;
	private OrderStatus status;
	private ReferencePerson referencePerson;
	
	Order(){
		this.customer = new Customer();
		this.orderLines = new ArrayList<>();
	}
	Order(String customerNumber, String orderNumber){
		this.customer = new Customer();
		this.customer.setCustomerNumber(customerNumber);
		this.orderNumber = orderNumber;
		this.orderLines = new ArrayList<>();
		
	}
	Order(Customer customer) {
		this.customer = customer;
		this.orderDate = LocalDateTime.now();
		this.orderNumber = UUID.randomUUID().toString();
		this.orderLines = new ArrayList<>();
	}
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
	}
	
	public List<OrderLine> getOrderLines() {
		return new ArrayList<>(this.orderLines);
	}
	
	public BigDecimal totalAmount() {
		BigDecimal total = BigDecimal.ZERO;
		for(OrderLine orderLine : this.orderLines) {
			total.add(orderLine.getPrice());
		}
		
		return total;
	}
	
	public LocalDateTime  getOrderDate() {
		return orderDate;
	}

	public Customer getCustomer() {
		return this.customer;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
	
	public OrderType getOrderType() {
		return orderType;
	}
	
	public Order withType(OrderType orderType) {
		this.orderType = orderType;
		return this;
	}
	
	public Order withStatus(OrderStatus orderStatus) {
		this.status = orderStatus;
		return this;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Order withReferencePerson(ReferencePerson refPerson) {
		this.referencePerson = refPerson;
		return this;
	}
	
	public void setReferencePerson(ReferencePerson referencePerson) {
		this.referencePerson = referencePerson;
	}
	public ReferencePerson getReferencePerson() {
		return referencePerson;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
