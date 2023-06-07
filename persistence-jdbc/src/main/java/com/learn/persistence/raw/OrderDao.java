package com.learn.persistence.raw;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.learn.domain.commons.persistence.Workspace;
import com.learn.domain.commons.persistence.WorkspaceException;
import com.learn.domain.orders.Order;
import com.learn.domain.orders.OrderFactory;
import com.learn.domain.orders.OrderLine;
import com.learn.domain.products.Product;
import com.learn.persistence.exception.DatabaseException;
import com.learn.persistence.helper.DatabaseHelper;

public class OrderDao implements Workspace<Order>{
	
	private Connection connection;
	
	public OrderDao(Connection conn) {
		this.connection = conn;
	}

	@Override
	public Order getById(String orderNumber)throws WorkspaceException {
     Order order =  null;
		
		String sql = "SELECT o.order_number, o.order_date, o.customer_number, i.product_code, i.quantity"
				+ " FROM orders o join order_item i on o.order_number=i.order_number"
				+" WHERE o.order_number = ?";
		
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, orderNumber);
			
			ResultSet rs = stm.executeQuery();
			
			int i = 1;
			while(rs.next()) {
				if(i == 1) {
					String customerNumber = rs.getString("customer_number");
					order = OrderFactory.createOrder(customerNumber, orderNumber);
				
				}
				if(order != null) {
					Product product = new Product(rs.getString("product_code"));
					OrderLine line = new OrderLine(product);
					order.addOrderLine(line);
					
				}else {
					throw new WorkspaceException("No data found");
				}
				i++;
			}
			
			
		} catch (SQLException e) {
			throw new WorkspaceException("No data found");
		}
		return order;
		
	}

	@Override
	public void makePersistence(Order order) throws WorkspaceException {
		String sqlInsertOrder = "INSERT INTO orders(order_number, order_date, customer_number) VALUES(?,?,?)";
		String sqlInsertItem = "INSERT INTO order_item(product_code, quantity, order_number) VALUES(?,?,?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sqlInsertOrder);
			stm.setString(1, order.getOrderNumber());
			stm.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			stm.setString(3, order.getCustomer().getCustomerNumber());
			
			stm.executeUpdate();
			
			for(OrderLine item : order.getOrderLines()) {
				PreparedStatement insertItemStm = connection.prepareStatement(sqlInsertItem);
				insertItemStm.setString(1, item.getProduct().getProductCode());
				insertItemStm.setInt(2, item.getQuantity());
				insertItemStm.setString(3, order.getOrderNumber());
				
				insertItemStm.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			throw new WorkspaceException("Failed saving order");
		}
		
	}

	@Override
	public void persistAll() throws WorkspaceException {
		try {
			DatabaseHelper.commitTransaction(connection);
		} catch (DatabaseException e) {
			throw new WorkspaceException("Failed persist order and order line");
		}
		
	}

}
