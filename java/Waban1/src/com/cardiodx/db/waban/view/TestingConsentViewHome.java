package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TestingConsentView.
 * @see com.cardiodx.db.waban.view.TestingConsentView
 * @author Hibernate Tools
 */
public class TestingConsentViewHome {

	private static final Log log = LogFactory
			.getLog(TestingConsentViewHome.class);

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

	public void persist(TestingConsentView transientInstance) {
		log.debug("persisting TestingConsentView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestingConsentView instance) {
		log.debug("attaching dirty TestingConsentView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestingConsentView instance) {
		log.debug("attaching clean TestingConsentView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestingConsentView persistentInstance) {
		log.debug("deleting TestingConsentView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestingConsentView merge(TestingConsentView detachedInstance) {
		log.debug("merging TestingConsentView instance");
		try {
			TestingConsentView result = (TestingConsentView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestingConsentView findById(
			com.cardiodx.db.waban.view.TestingConsentViewId id) {
		log.debug("getting TestingConsentView instance with id: " + id);
		try {
			TestingConsentView instance = (TestingConsentView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.TestingConsentView", id);
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

	public List<TestingConsentView> findByExample(TestingConsentView instance) {
		log.debug("finding TestingConsentView instance by example");
		try {
			List<TestingConsentView> results = (List<TestingConsentView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.TestingConsentView")
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
