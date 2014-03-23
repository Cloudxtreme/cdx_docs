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
 * Home object for domain model class TestConditionRoiView.
 * @see com.cardiodx.db.waban.view.TestConditionRoiView
 * @author Hibernate Tools
 */
public class TestConditionRoiViewHome {

	private static final Log log = LogFactory
			.getLog(TestConditionRoiViewHome.class);

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

	public void persist(TestConditionRoiView transientInstance) {
		log.debug("persisting TestConditionRoiView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TestConditionRoiView instance) {
		log.debug("attaching dirty TestConditionRoiView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TestConditionRoiView instance) {
		log.debug("attaching clean TestConditionRoiView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TestConditionRoiView persistentInstance) {
		log.debug("deleting TestConditionRoiView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TestConditionRoiView merge(TestConditionRoiView detachedInstance) {
		log.debug("merging TestConditionRoiView instance");
		try {
			TestConditionRoiView result = (TestConditionRoiView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TestConditionRoiView findById(
			com.cardiodx.db.waban.view.TestConditionRoiViewId id) {
		log.debug("getting TestConditionRoiView instance with id: " + id);
		try {
			TestConditionRoiView instance = (TestConditionRoiView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TestConditionRoiView",
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

	public List<TestConditionRoiView> findByExample(
			TestConditionRoiView instance) {
		log.debug("finding TestConditionRoiView instance by example");
		try {
			List<TestConditionRoiView> results = (List<TestConditionRoiView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.TestConditionRoiView")
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
