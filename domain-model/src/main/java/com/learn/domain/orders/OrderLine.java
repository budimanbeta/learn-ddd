package com.learn.domain.orders;

import java.math.BigDecimal;

import com.learn.domain.products.Product;

public class OrderLine {

	private BigDecimal price = BigDecimal.ZERO;
	private Product product;
	private int quantity;
	
	public OrderLine(Product product) {
		this.product = product;
		this.quantity = 0;
	}
	public OrderLine(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public BigDecimal totalAmount() {
		return getPrice().multiply(BigDecimal.valueOf(quantity));
	}
	public Product getProduct() {
		return product;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	
	
	
}
