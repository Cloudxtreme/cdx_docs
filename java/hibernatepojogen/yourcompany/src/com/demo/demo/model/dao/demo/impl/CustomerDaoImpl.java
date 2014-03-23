package com.demo.demo.model.dao.demo.impl;

import java.io.Serializable;
import com.demo.persistence.impl.GenericHibernateDaoImpl;
import com.demo.demo.model.obj.demo.Customer;
import org.springframework.stereotype.Repository;
import com.demo.demo.model.dao.demo.CustomerDao;

/**
 * DAO for table: Customer.
 * @author autogenerated
 */
@Repository
public class CustomerDaoImpl extends GenericHibernateDaoImpl<Customer, Serializable> implements CustomerDao {
	
	/** Constructor method. */
		public CustomerDaoImpl() {
			super(Customer.class);
		}
	}

