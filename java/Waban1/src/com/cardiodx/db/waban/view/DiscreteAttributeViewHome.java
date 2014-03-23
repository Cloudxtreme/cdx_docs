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
 * Home object for domain model class DiscreteAttributeView.
 * @see com.cardiodx.db.waban.view.DiscreteAttributeView
 * @author Hibernate Tools
 */
public class DiscreteAttributeViewHome {

	private static final Log log = LogFactory
			.getLog(DiscreteAttributeViewHome.class);

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

	public void persist(DiscreteAttributeView transientInstance) {
		log.debug("persisting DiscreteAttributeView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DiscreteAttributeView instance) {
		log.debug("attaching dirty DiscreteAttributeView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DiscreteAttributeView instance) {
		log.debug("attaching clean DiscreteAttributeView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DiscreteAttributeView persistentInstance) {
		log.debug("deleting DiscreteAttributeView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DiscreteAttributeView merge(DiscreteAttributeView detachedInstance) {
		log.debug("merging DiscreteAttributeView instance");
		try {
			DiscreteAttributeView result = (DiscreteAttributeView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DiscreteAttributeView findById(
			com.cardiodx.db.waban.view.DiscreteAttributeViewId id) {
		log.debug("getting DiscreteAttributeView instance with id: " + id);
		try {
			DiscreteAttributeView instance = (DiscreteAttributeView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.DiscreteAttributeView",
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

	public List<DiscreteAttributeView> findByExample(
			DiscreteAttributeView instance) {
		log.debug("finding DiscreteAttributeView instance by example");
		try {
			List<DiscreteAttributeView> results = (List<DiscreteAttributeView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.DiscreteAttributeView")
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
