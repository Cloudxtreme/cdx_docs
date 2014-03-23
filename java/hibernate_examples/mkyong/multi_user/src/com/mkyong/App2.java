package com.mkyong;
 
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mkyong.util.HibernateUtil;
import com.mkyong.user.DBUser;
 
public class App2 {
	public static void main(String[] args) {


//		Configuration config = new Configuration().configure("bin/hibernate.cfg.xml");
		Configuration config = new Configuration().configure();

		config.setProperty("hibernate.default_schema", "hello");
		config.setProperty("hibernate.connection.username", "hello");
		config.setProperty("hibernate.connection.password", "cchou1200");

		SessionFactory sf1 = config.buildSessionFactory();
		Session s1 = sf1.openSession();

        config.setProperty("hibernate.default_schema", "world");
        config.setProperty("hibernate.connection.username", "world");
        config.setProperty("hibernate.connection.password", "cchou1200");

        //SessionFactory sf2 = config.buildSessionFactory();
        //Session s2 = sf2.openSession();
        sf1 = config.buildSessionFactory();
        Session s2 = sf1.openSession();

		s1.beginTransaction();
        s2.beginTransaction();
		  DBUser u1 = new DBUser();
		  u1.setUsername("superman");
		  u1.setCreatedBy("system");
		  u1.setCreatedDate(new Date());
		  s1.save(u1);
		s1.getTransaction().commit();

          DBUser u2 = new DBUser();
          u2.setUsername("superman");
          u2.setCreatedBy("system");
          u2.setCreatedDate(new Date());
          s2.save(u2);
        s2.getTransaction().commit();

boolean flag = true;
while (flag) {}

	}
}
