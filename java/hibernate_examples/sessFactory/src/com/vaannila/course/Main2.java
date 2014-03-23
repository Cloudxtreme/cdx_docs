package com.vaannila.course;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import com.vaannila.util.HibernateUtil;

public class Main2 {

	public static void main(String[] args) {
        Configuration configuration = new Configuration();
//            configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
//            configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost");
//            configuration.setProperty("hibernate.connection.username", "sa");
//            configuration.setProperty("connection.password", "");
//            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
            configuration.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
            configuration.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@desktop30:1521:orcl");
            configuration.setProperty("hibernate.connection.username", "hello");
            configuration.setProperty("connection.password", "cchou1200");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");

            configuration.setProperty("connection.pool_size", "1");
            configuration.setProperty("show_sql", "true");
//            configuration.setProperty("hbm2ddl.auto", "create");
            configuration.addResource("com/vaannila/course/Course.hbm.xml");


        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();   
        transaction.begin();

		List courses = session.createQuery("from Course").list();
		for (Iterator iterator = courses.iterator(); iterator.hasNext();) {
			Course course = (Course) iterator.next();
			System.out.println(course.getCourseName());
		}

        Course course = new Course();
        course.setCourseName("Hello1");
        Long courseId = (Long) session.save(course);
	
        transaction.commit();
        session.close();
	}
}
