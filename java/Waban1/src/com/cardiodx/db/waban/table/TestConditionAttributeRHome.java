package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TestConditionAttributeR.
 * @see com.cardiodx.db.waban.table.TestConditionAttributeR
 * @author Hibernate Tools
 */
public class TestConditionAttributeRHome {

	private static final Log log = LogFactory
			.getLog(TestConditionAttributeRHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TestConditionAttributeR transientInstance) {
		log.debug("persisting TestConditionAttributeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestConditionAttributeR instance) {
		log.debug("attaching dirty TestConditionAttributeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestConditionAttributeR instance) {
		log.debug("attaching clean TestConditionAttributeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestConditionAttributeR persistentInstance) {
		log.debug("deleting TestConditionAttributeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestConditionAttributeR merge(
			TestConditionAttributeR detachedInstance) {
		log.debug("merging TestConditionAttributeR instance");
		try {
			TestConditionAttributeR result = (TestConditionAttributeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestConditionAttributeR findById(
			com.cardiodx.db.waban.table.TestConditionAttributeRId id) {
		log.debug("getting TestConditionAttributeR instance with id: " + id);
		try {
			TestConditionAttributeR instance = (TestConditionAttributeR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.TestConditionAttributeR",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TestConditionAttributeR> findByExample(
			TestConditionAttributeR instance) {
		log.debug("finding TestConditionAttributeR instance by example");
		try {
			List<TestConditionAttributeR> results = (List<TestConditionAttributeR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TestConditionAttributeR")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
