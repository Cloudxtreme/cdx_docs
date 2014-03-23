package com.mkyong;
 
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;
 
public class App {
	public static void main(String[] args) {
		System.out.println("Maven + Hibernate + Oracle");

		Configuration config = new Configuration().configure("bin/hibernate.cfg.xml");
			config.setProperty("hibernate.default_schema", "world");
			config.setProperty("hibernate.connection.username", "world");
			config.setProperty("connection.password", "cchou1200");

		SessionFactory sessionFactory = config.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		DBUser user = new DBUser();
		user.setUsername("superman");
		user.setCreatedBy("system");
		user.setCreatedDate(new Date());
		session.save(user);
		session.getTransaction().commit();
	}
}
