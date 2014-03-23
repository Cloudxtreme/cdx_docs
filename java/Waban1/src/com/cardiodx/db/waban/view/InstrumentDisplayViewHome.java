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
 * Home object for domain model class InstrumentDisplayView.
 * @see com.cardiodx.db.waban.view.InstrumentDisplayView
 * @author Hibernate Tools
 */
public class InstrumentDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(InstrumentDisplayViewHome.class);

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

	public void persist(InstrumentDisplayView transientInstance) {
		log.debug("persisting InstrumentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InstrumentDisplayView instance) {
		log.debug("attaching dirty InstrumentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InstrumentDisplayView instance) {
		log.debug("attaching clean InstrumentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InstrumentDisplayView persistentInstance) {
		log.debug("deleting InstrumentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InstrumentDisplayView merge(InstrumentDisplayView detachedInstance) {
		log.debug("merging InstrumentDisplayView instance");
		try {
			InstrumentDisplayView result = (InstrumentDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InstrumentDisplayView findById(
			com.cardiodx.db.waban.view.InstrumentDisplayViewId id) {
		log.debug("getting InstrumentDisplayView instance with id: " + id);
		try {
			InstrumentDisplayView instance = (InstrumentDisplayView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.InstrumentDisplayView",
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

	public List<InstrumentDisplayView> findByExample(
			InstrumentDisplayView instance) {
		log.debug("finding InstrumentDisplayView instance by example");
		try {
			List<InstrumentDisplayView> results = (List<InstrumentDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.InstrumentDisplayView")
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
