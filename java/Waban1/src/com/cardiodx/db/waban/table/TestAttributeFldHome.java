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
 * Home object for domain model class TestAttributeFld.
 * @see com.cardiodx.db.waban.table.TestAttributeFld
 * @author Hibernate Tools
 */
public class TestAttributeFldHome {

	private static final Log log = LogFactory
			.getLog(TestAttributeFldHome.class);

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

	public void persist(TestAttributeFld transientInstance) {
		log.debug("persisting TestAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestAttributeFld instance) {
		log.debug("attaching dirty TestAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestAttributeFld instance) {
		log.debug("attaching clean TestAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestAttributeFld persistentInstance) {
		log.debug("deleting TestAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestAttributeFld merge(TestAttributeFld detachedInstance) {
		log.debug("merging TestAttributeFld instance");
		try {
			TestAttributeFld result = (TestAttributeFld) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestAttributeFld findById(java.math.BigDecimal id) {
		log.debug("getting TestAttributeFld instance with id: " + id);
		try {
			TestAttributeFld instance = (TestAttributeFld) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TestAttributeFld", id);
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

	public List<TestAttributeFld> findByExample(TestAttributeFld instance) {
		log.debug("finding TestAttributeFld instance by example");
		try {
			List<TestAttributeFld> results = (List<TestAttributeFld>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TestAttributeFld")
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
