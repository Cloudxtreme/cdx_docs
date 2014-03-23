package com.vaannila.course;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import com.vaannila.util.HibernateUtil;

public class Main1 {

	public static void main(String[] args) {
        Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
            configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost");
            configuration.setProperty("hibernate.connection.username", "sa");
            configuration.setProperty("connection.password", "");
            configuration.setProperty("connection.pool_size", "1");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
            configuration.setProperty("show_sql", "true");
//            configuration.setProperty("hbm2ddl.auto", "create");
            configuration.addResource("com/vaannila/course/Course.hbm.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();   
        transaction.begin();

			List courses = session.createQuery("from Course").list();
			for (Iterator iterator = courses.iterator(); iterator.hasNext();)
			{
				Course course = (Course) iterator.next();
				System.out.println(course.getCourseName());
			}

	
        transaction.commit();
        session.close();
	}
}
