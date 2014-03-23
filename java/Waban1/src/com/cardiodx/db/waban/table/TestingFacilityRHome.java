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
 * Home object for domain model class TestingFacilityR.
 * @see com.cardiodx.db.waban.table.TestingFacilityR
 * @author Hibernate Tools
 */
public class TestingFacilityRHome {

	private static final Log log = LogFactory
			.getLog(TestingFacilityRHome.class);

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

	public void persist(TestingFacilityR transientInstance) {
		log.debug("persisting TestingFacilityR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestingFacilityR instance) {
		log.debug("attaching dirty TestingFacilityR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestingFacilityR instance) {
		log.debug("attaching clean TestingFacilityR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestingFacilityR persistentInstance) {
		log.debug("deleting TestingFacilityR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestingFacilityR merge(TestingFacilityR detachedInstance) {
		log.debug("merging TestingFacilityR instance");
		try {
			TestingFacilityR result = (TestingFacilityR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestingFacilityR findById(
			com.cardiodx.db.waban.table.TestingFacilityRId id) {
		log.debug("getting TestingFacilityR instance with id: " + id);
		try {
			TestingFacilityR instance = (TestingFacilityR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TestingFacilityR", id);
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

	public List<TestingFacilityR> findByExample(TestingFacilityR instance) {
		log.debug("finding TestingFacilityR instance by example");
		try {
			List<TestingFacilityR> results = (List<TestingFacilityR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TestingFacilityR")
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
