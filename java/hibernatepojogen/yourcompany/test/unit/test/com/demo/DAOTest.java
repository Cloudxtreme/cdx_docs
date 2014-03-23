 package test.com.demo;

import org.junit.Assert;
import org.junit.Test;
import java.io.Serializable;


import com.demo.demo.factories.demo.*;
import com.demo.demo.model.obj.demo.*;
import com.demo.demo.services.data.DataLayerDemo;
import com.demo.demo.services.data.DataLayerDemoImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

/** Hibernate tester.
* @author autogenerated
*/
@SuppressWarnings("cast")
@ContextConfiguration(locations = { "/applicationContext.xml" } )
@RunWith(SpringJUnit4ClassRunner.class)
public class DAOTest {
		

	/**
	 * Clears the database.
	 */
	@Test
	@Transactional
	public void testPreCleanDBFirstPass() {
		// We'll ignore any exceptions in this pass to give time for the custom exec to execute too 
		// (+ clear out any DB loops)
	
		try{HibernateDemoDaoFactory.getLineDao().getQuery("delete from Line").executeUpdate(); } catch (Exception e) { /* do nothing */ }
		try{HibernateDemoDaoFactory.getStockDao().getQuery("delete from Stock").executeUpdate(); } catch (Exception e) { /* do nothing */ }
		try{HibernateDemoDaoFactory.getOrderDao().getQuery("delete from Order").executeUpdate(); } catch (Exception e) { /* do nothing */ }
		try{HibernateDemoDaoFactory.getCustomerDao().getQuery("delete from Customer").executeUpdate(); } catch (Exception e) { /* do nothing */ }


		
	}
	/**
	 * Clears the database.
	 */
	@Test
	@Transactional
	public void testPreCleanDBFinalPass() {
	
		HibernateDemoDaoFactory.getLineDao().getQuery("delete from Line").executeUpdate();
		HibernateDemoDaoFactory.getStockDao().getQuery("delete from Stock").executeUpdate();
		HibernateDemoDaoFactory.getOrderDao().getQuery("delete from Order").executeUpdate();
		HibernateDemoDaoFactory.getCustomerDao().getQuery("delete from Customer").executeUpdate();


		
	}

	
	/**
	 * Hibernate test case for table: demo.customer.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testCustomer() throws CloneNotSupportedException {

	 	DataLayerDemo dataLayerDemo = DataLayerDemoImpl.getInstance();
		Customer customer = DemoDataPoolFactory.getCustomer();
		dataLayerDemo.saveOrUpdate(customer);
		dataLayerDemo.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerDemo.evict(customer); 		 

		Serializable customerId = customer.getId();
		Customer copy = customer.clone();

		customer = dataLayerDemo.getCustomer(customerId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		
		Assert.assertEquals(copy.getName(), customer.getName());
		Assert.assertEquals(copy.getSurname(), customer.getSurname());
		// tests for coverage completeness
		Assert.assertFalse(customer.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		Assert.assertEquals(copy, copy);
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}
	/**
	 * Hibernate test case for table: demo.line.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testLine() throws CloneNotSupportedException {

	 	DataLayerDemo dataLayerDemo = DataLayerDemoImpl.getInstance();
		Line line = DemoDataPoolFactory.getLine();
		dataLayerDemo.saveOrUpdate(line);
		dataLayerDemo.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerDemo.evict(line); 		 

		Serializable lineId = line.getId();
		Line copy = line.clone();

		line = dataLayerDemo.getLine(lineId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		
		Assert.assertEquals(copy.getComment(), line.getComment());
		Assert.assertEquals(copy.getOrder().getId(), line.getOrder().getId());
		Assert.assertEquals(copy.getQuantity(), line.getQuantity());
		Assert.assertEquals(copy.getStock().getId(), line.getStock().getId());
		// tests for coverage completeness
		Assert.assertFalse(line.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		Assert.assertEquals(copy, copy);
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}
	/**
	 * Hibernate test case for table: demo.order.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testOrder() throws CloneNotSupportedException {

	 	DataLayerDemo dataLayerDemo = DataLayerDemoImpl.getInstance();
		Order order = DemoDataPoolFactory.getOrder();
		dataLayerDemo.saveOrUpdate(order);
		dataLayerDemo.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerDemo.evict(order); 		 

		Serializable orderId = order.getId();
		Order copy = order.clone();

		order = dataLayerDemo.getOrder(orderId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		
		Assert.assertEquals(copy.getCustomer().getId(), order.getCustomer().getId());
		Assert.assertEquals(copy.getOrderDate().getTime() / 1000, order.getOrderDate().getTime() / 1000);
		// tests for coverage completeness
		Assert.assertFalse(order.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		Assert.assertEquals(copy, copy);
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}
	/**
	 * Hibernate test case for table: demo.stock.
	 * @throws CloneNotSupportedException on clone error
	 */
	@Transactional
	@Test		
	public void testStock() throws CloneNotSupportedException {

	 	DataLayerDemo dataLayerDemo = DataLayerDemoImpl.getInstance();
		Stock stock = DemoDataPoolFactory.getStock();
		dataLayerDemo.saveOrUpdate(stock);
		dataLayerDemo.flushSession(); // flush+evict from cache to make sure we hit the DB next 
		dataLayerDemo.evict(stock); 		 

		Serializable stockId = stock.getId();
		Stock copy = stock.clone();

		stock = dataLayerDemo.getStock(stockId); 	// load it again


		// Validity checks
		Assert.assertNotNull(copy);
		
		Assert.assertEquals(copy.getDescription(), stock.getDescription());
		// tests for coverage completeness
		Assert.assertFalse(stock.toString().equals(""));
		Assert.assertEquals(copy, copy.clone());
		Assert.assertEquals(copy, copy);
		Assert.assertNotSame(copy, 0L);
	  // End of table
	}

	/**
	 * Clears the database.
	 */
	@Test
	@Transactional
	public void testPostCleanDBFirstPass() {
		// We'll ignore any exceptions in this pass to give time for the custom exec to execute too 
		// (+ clear out any DB loops)
	
		try{HibernateDemoDaoFactory.getLineDao().getQuery("delete from Line").executeUpdate(); } catch (Exception e) { /* do nothing */ }
		try{HibernateDemoDaoFactory.getStockDao().getQuery("delete from Stock").executeUpdate(); } catch (Exception e) { /* do nothing */ }
		try{HibernateDemoDaoFactory.getOrderDao().getQuery("delete from Order").executeUpdate(); } catch (Exception e) { /* do nothing */ }
		try{HibernateDemoDaoFactory.getCustomerDao().getQuery("delete from Customer").executeUpdate(); } catch (Exception e) { /* do nothing */ }


		
	}

	/**
	 * Clears the database.
	 */
	@Test
	@Transactional
	public void postCleanDBFinalPass() {
	
		HibernateDemoDaoFactory.getLineDao().getQuery("delete from Line").executeUpdate();
		HibernateDemoDaoFactory.getStockDao().getQuery("delete from Stock").executeUpdate();
		HibernateDemoDaoFactory.getOrderDao().getQuery("delete from Order").executeUpdate();
		HibernateDemoDaoFactory.getCustomerDao().getQuery("delete from Customer").executeUpdate();


		
	}

}


