/**
 * 
 */
package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wallacew
 *
 */
public class ExampleAppMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// set up spring.
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// get a reference to the class
		IExampleApp exampleApp = (IExampleApp)context.getBean("exampleApp");
		// call the function in that class via spring
		exampleApp.writeSomething();
	}

}
