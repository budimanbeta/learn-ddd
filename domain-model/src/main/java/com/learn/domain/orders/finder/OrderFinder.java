package com.learn.domain.orders.finder;

import java.util.List;

import com.learn.domain.orders.Order;

public interface OrderFinder {
	List<Order> findByCustomerNumber(String customerNumber);
}
