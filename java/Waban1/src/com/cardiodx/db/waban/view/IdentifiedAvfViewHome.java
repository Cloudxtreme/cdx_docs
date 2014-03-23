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
 * Home object for domain model class IdentifiedAvfView.
 * @see com.cardiodx.db.waban.view.IdentifiedAvfView
 * @author Hibernate Tools
 */
public class IdentifiedAvfViewHome {

	private static final Log log = LogFactory
			.getLog(IdentifiedAvfViewHome.class);

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

	public void persist(IdentifiedAvfView transientInstance) {
		log.debug("persisting IdentifiedAvfView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IdentifiedAvfView instance) {
		log.debug("attaching dirty IdentifiedAvfView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IdentifiedAvfView instance) {
		log.debug("attaching clean IdentifiedAvfView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IdentifiedAvfView persistentInstance) {
		log.debug("deleting IdentifiedAvfView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IdentifiedAvfView merge(IdentifiedAvfView detachedInstance) {
		log.debug("merging IdentifiedAvfView instance");
		try {
			IdentifiedAvfView result = (IdentifiedAvfView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IdentifiedAvfView findById(
			com.cardiodx.db.waban.view.IdentifiedAvfViewId id) {
		log.debug("getting IdentifiedAvfView instance with id: " + id);
		try {
			IdentifiedAvfView instance = (IdentifiedAvfView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.IdentifiedAvfView", id);
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

	public List<IdentifiedAvfView> findByExample(IdentifiedAvfView instance) {
		log.debug("finding IdentifiedAvfView instance by example");
		try {
			List<IdentifiedAvfView> results = (List<IdentifiedAvfView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.IdentifiedAvfView")
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
