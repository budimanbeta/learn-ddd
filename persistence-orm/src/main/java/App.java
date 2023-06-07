

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.learn.domain.orders.Order;
import com.learn.domain.orders.OrderFactory;
import com.learn.domain.orders.OrderLine;
import com.learn.domain.products.Product;

/**
 * JPA Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			emf = Persistence.createEntityManagerFactory("jbd-pu");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Order order = OrderFactory.createOrder("CA123", "O001");
			Product product1 = new Product("P001");
			Product product2 = new Product("P002");
			order.addOrderLine(new OrderLine(product1));
			order.addOrderLine(new OrderLine(product2));
			entityManager.persist(order);

			transaction.commit();

//			Query q = entityManager.createQuery("select s from Stu s");
//
//			List<Student> resultList = q.getResultList();
//			System.out.println("num of sudents:" + resultList.size());
//			for (Student next : resultList) {
//				System.out.println("next student: " + next);
//			}

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			entityManager.close();
			emf.close();
		}
	}
}
