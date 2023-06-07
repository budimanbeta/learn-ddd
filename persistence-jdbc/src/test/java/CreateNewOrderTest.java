

import java.sql.Connection;

import com.learn.domain.commons.persistence.Workspace;
import com.learn.domain.customers.Customer;
import com.learn.domain.orders.Order;
import com.learn.domain.orders.OrderFactory;
import com.learn.domain.orders.OrderLine;
import com.learn.domain.orders.OrderRepository;
import com.learn.domain.products.Product;
import com.learn.persistence.exception.DatabaseException;
import com.learn.persistence.helper.DatabaseHelper;
import com.learn.persistence.raw.OrderDao;

public class CreateNewOrderTest {

	public static void main(String[] args) throws DatabaseException {
//		Order order = OrderFactory.createOrder("CA123", "O001");
//		Product product1 = new Product("P001");
//		Product product2 = new Product("P002");
//		order.addOrderLine(new OrderLine(product1));
//		order.addOrderLine(new OrderLine(product2));
//		
		Connection conn = DatabaseHelper.getConnection();
	
		OrderRepository orderRepo = new OrderRepository(new OrderDao(conn), null);
		//orderRepo.addOrder(order);
		
		Order retrieveOrder = orderRepo.getOrder("O001");
		
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
