package com.mkyong;
 
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;
 
public class App1 {
	public static void main(String[] args) {


System.out.println("-----------------------------------> begin hello");
		Configuration c1 = new Configuration().configure("bin/hibernate.cfg.xml");
			c1.setProperty("hibernate.default_schema", "hello");
			c1.setProperty("hibernate.connection.username", "hello");
			c1.setProperty("connection.password", "cchou1200");

		SessionFactory sf1 = c1.buildSessionFactory();
		Session s1 = sf1.openSession();

		s1.beginTransaction();
		DBUser u1 = new DBUser();
		u1.setUsername("superman");
		u1.setCreatedBy("system");
		u1.setCreatedDate(new Date());
		s1.save(u1);
		s1.getTransaction().commit();

System.out.println("-----------------------------------> begin world");
        Configuration c2 = new Configuration().configure("bin/hibernate.cfg.xml");
            c2.setProperty("hibernate.default_schema", "world");
            c2.setProperty("hibernate.connection.username", "world");
            c2.setProperty("connection.password", "cchou1200");

        SessionFactory sf2 = c2.buildSessionFactory();
        Session s2 = sf2.openSession();

        s2.beginTransaction();
        DBUser u2 = new DBUser();
        u2.setUsername("superman");
        u2.setCreatedBy("system");
        u2.setCreatedDate(new Date());
        s2.save(u2);
        s2.getTransaction().commit();

	}
}
