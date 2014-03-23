package com.vaannila.course;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import com.vaannila.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Main obj = new Main();
		SessionFactory sf = obj.getSessionFactory();
		Long courseId1 = obj.saveCourse(sf, "Physics");
		Long courseId2 = obj.saveCourse(sf, "Chemistry");
		Long courseId3 = obj.saveCourse(sf, "Maths");
		obj.listCourse(sf);
//		obj.updateCourse(sf, courseId3, "Test");
//		obj.deleteCourse(sf, courseId2);
//		obj.listCourse(sf);
	}

	public SessionFactory getSessionFactory() {

		Configuration conf = new Configuration()
			.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver")
			.setProperty("hibernate.connection.url", "jdbc:hsqldb:hsql://localhost")
			.setProperty("hibernate.connection.username", "sa")
			.setProperty("connection.password", "")
			.setProperty("connection.pool_size", "1")
			.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
			.setProperty("show_sql", "true")
			.setProperty("hbm2ddl.auto", "create")
			.addResource("com/vaannila/course/Course.hbm.xml");

		SessionFactory sf = conf.buildSessionFactory();

		return sf;
	}
	
	public Long saveCourse(SessionFactory sf, String courseName)
	{
		Session session = sf.openSession();
		
		Transaction transaction = null;
		Long courseId = null;
		try {
			transaction = session.beginTransaction();
			Course course = new Course();
			course.setCourseName(courseName);
			courseId = (Long) session.save(course);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return courseId;
	}
	
	public void listCourse(SessionFactory sf)
	{
		Session session = sf.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List courses = session.createQuery("from Course").list();
			for (Iterator iterator = courses.iterator(); iterator.hasNext();)
			{
				Course course = (Course) iterator.next();
				System.out.println(course.getCourseName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void updateCourse(SessionFactory sf, Long courseId, String courseName)
	{
		Session session = sf.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Course course = (Course) session.get(Course.class, courseId);
			course.setCourseName(courseName);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void deleteCourse(SessionFactory sf, Long courseId)
	{
		Session session = sf.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Course course = (Course) session.get(Course.class, courseId);
			session.delete(course);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
