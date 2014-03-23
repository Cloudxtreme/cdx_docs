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
 * Home object for domain model class TestAccessionR.
 * @see com.cardiodx.db.waban.table.TestAccessionR
 * @author Hibernate Tools
 */
public class TestAccessionRHome {

	private static final Log log = LogFactory.getLog(TestAccessionRHome.class);

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

	public void persist(TestAccessionR transientInstance) {
		log.debug("persisting TestAccessionR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestAccessionR instance) {
		log.debug("attaching dirty TestAccessionR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestAccessionR instance) {
		log.debug("attaching clean TestAccessionR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestAccessionR persistentInstance) {
		log.debug("deleting TestAccessionR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestAccessionR merge(TestAccessionR detachedInstance) {
		log.debug("merging TestAccessionR instance");
		try {
			TestAccessionR result = (TestAccessionR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestAccessionR findById(
			com.cardiodx.db.waban.table.TestAccessionRId id) {
		log.debug("getting TestAccessionR instance with id: " + id);
		try {
			TestAccessionR instance = (TestAccessionR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TestAccessionR", id);
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

	public List<TestAccessionR> findByExample(TestAccessionR instance) {
		log.debug("finding TestAccessionR instance by example");
		try {
			List<TestAccessionR> results = (List<TestAccessionR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TestAccessionR")
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
