package com.demo.demo.factories.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.BeanNameAware;

import com.demo.demo.model.dao.demo.*;

/** 
 * DAO factory implementation.
 * @author autogenerated
 */
@Component
public class HibernateDemoDaoFactory implements ApplicationContextAware, BeanNameAware {
	/** Placeholder for an instance. */
	private static HibernateDemoDaoFactory instance;
	/** Internal state. */
	private static ApplicationContext context = null;
	/** Bean Name. */
	private static String beanName;

	/** Return an instance of this class.
	 * @return an instance of this class
	 */
	public static synchronized HibernateDemoDaoFactory getInstance() {
		if (instance == null) {
			instance = (HibernateDemoDaoFactory) context.getBean(beanName);
		}
		return instance;
	}

	/**
	 * Sets a Spring Application Context object.
  	 * @param ctxt ApplicationContext to set
	 * @throws BeansException on spring error
	 */
	@Autowired
	public void setApplicationContext(ApplicationContext ctxt)
			throws BeansException 
	{
		context = ctxt;
	}


	@Override
	public void setBeanName(String name) {
		beanName = name;
	}
	
	/**
	 * Returns a CustomerDao instance.
	 * 
	 * @return a CustomerDao instance
	 */
	public static CustomerDao getCustomerDao() {
		return (CustomerDao) context.getBean("customerDaoImpl");
	}

	/**
	 * Returns a LineDao instance.
	 * 
	 * @return a LineDao instance
	 */
	public static LineDao getLineDao() {
		return (LineDao) context.getBean("lineDaoImpl");
	}

	/**
	 * Returns a OrderDao instance.
	 * 
	 * @return a OrderDao instance
	 */
	public static OrderDao getOrderDao() {
		return (OrderDao) context.getBean("orderDaoImpl");
	}

	/**
	 * Returns a StockDao instance.
	 * 
	 * @return a StockDao instance
	 */
	public static StockDao getStockDao() {
		return (StockDao) context.getBean("stockDaoImpl");
	}


}