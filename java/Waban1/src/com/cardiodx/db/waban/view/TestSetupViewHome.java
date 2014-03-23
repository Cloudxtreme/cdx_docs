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
 * Home object for domain model class TestSetupView.
 * @see com.cardiodx.db.waban.view.TestSetupView
 * @author Hibernate Tools
 */
public class TestSetupViewHome {

	private static final Log log = LogFactory.getLog(TestSetupViewHome.class);

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

	public void persist(TestSetupView transientInstance) {
		log.debug("persisting TestSetupView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestSetupView instance) {
		log.debug("attaching dirty TestSetupView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestSetupView instance) {
		log.debug("attaching clean TestSetupView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestSetupView persistentInstance) {
		log.debug("deleting TestSetupView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestSetupView merge(TestSetupView detachedInstance) {
		log.debug("merging TestSetupView instance");
		try {
			TestSetupView result = (TestSetupView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestSetupView findById(com.cardiodx.db.waban.view.TestSetupViewId id) {
		log.debug("getting TestSetupView instance with id: " + id);
		try {
			TestSetupView instance = (TestSetupView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TestSetupView", id);
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

	public List<TestSetupView> findByExample(TestSetupView instance) {
		log.debug("finding TestSetupView instance by example");
		try {
			List<TestSetupView> results = (List<TestSetupView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TestSetupView")
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
