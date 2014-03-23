package com.demo;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.demo.model.obj.demo.Customer;
import com.demo.demo.model.obj.demo.Line;
import com.demo.demo.model.obj.demo.Order;
import com.demo.demo.model.obj.demo.Stock;
import com.demo.demo.services.data.DataLayerDemoImpl;

/** Demo application.
 * @author wallacew
 *
 */
// The @Component tag is necessary for spring to register this 
// class as a bean and allow us to call context.getBean("exampleApp") without
// manually specifying this class in the applicationContext.xml file.

@Component
public class ExampleApp implements IExampleApp {
	
	// The @Transactional signals spring to initialise a session and a 
	// transaction and close them at the end of this method. 
	
	@Transactional
	public void writeSomething() {
		
		// Create a bunch of items
		Customer customer = new Customer();
		customer.setName("John");
		customer.setSurname("Smith");
		
		Order order = new Order();
		order.setOrderDate(new Date());
		
		Line line = new Line();
		line.setComment("some comment");
		line.setQuantity(1L);
		
		Stock stock = new Stock();
		stock.setDescription("A stock item");
		
		// link the items to together.
		customer.addOrder(order);
		order.addLine(line);
		line.setStock(stock);
		
		// Save everything. Cascading will ensure all instances will be saved
		DataLayerDemoImpl.getInstance().save(customer);
		
		// id will be filled in by hibernate when record is saved.
		Long savedId = customer.getId();
		
		// read record back.
		Customer savedCustomer = DataLayerDemoImpl.getInstance().getCustomer(savedId);
		
		// write something from that record out.
		System.out.println(savedCustomer.getName());
		
		// transaction will be rolled back/committed by spring automatically. 
	}
}
