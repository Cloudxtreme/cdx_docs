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
 * Home object for domain model class TestSetupAttrView.
 * @see com.cardiodx.db.waban.view.TestSetupAttrView
 * @author Hibernate Tools
 */
public class TestSetupAttrViewHome {

	private static final Log log = LogFactory
			.getLog(TestSetupAttrViewHome.class);

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

	public void persist(TestSetupAttrView transientInstance) {
		log.debug("persisting TestSetupAttrView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestSetupAttrView instance) {
		log.debug("attaching dirty TestSetupAttrView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestSetupAttrView instance) {
		log.debug("attaching clean TestSetupAttrView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestSetupAttrView persistentInstance) {
		log.debug("deleting TestSetupAttrView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestSetupAttrView merge(TestSetupAttrView detachedInstance) {
		log.debug("merging TestSetupAttrView instance");
		try {
			TestSetupAttrView result = (TestSetupAttrView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestSetupAttrView findById(
			com.cardiodx.db.waban.view.TestSetupAttrViewId id) {
		log.debug("getting TestSetupAttrView instance with id: " + id);
		try {
			TestSetupAttrView instance = (TestSetupAttrView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TestSetupAttrView", id);
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

	public List<TestSetupAttrView> findByExample(TestSetupAttrView instance) {
		log.debug("finding TestSetupAttrView instance by example");
		try {
			List<TestSetupAttrView> results = (List<TestSetupAttrView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.TestSetupAttrView")
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
