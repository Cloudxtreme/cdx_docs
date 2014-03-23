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
 * Home object for domain model class AccessionDisplayView.
 * @see com.cardiodx.db.waban.view.AccessionDisplayView
 * @author Hibernate Tools
 */
public class AccessionDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(AccessionDisplayViewHome.class);

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

	public void persist(AccessionDisplayView transientInstance) {
		log.debug("persisting AccessionDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AccessionDisplayView instance) {
		log.debug("attaching dirty AccessionDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccessionDisplayView instance) {
		log.debug("attaching clean AccessionDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AccessionDisplayView persistentInstance) {
		log.debug("deleting AccessionDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccessionDisplayView merge(AccessionDisplayView detachedInstance) {
		log.debug("merging AccessionDisplayView instance");
		try {
			AccessionDisplayView result = (AccessionDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AccessionDisplayView findById(
			com.cardiodx.db.waban.view.AccessionDisplayViewId id) {
		log.debug("getting AccessionDisplayView instance with id: " + id);
		try {
			AccessionDisplayView instance = (AccessionDisplayView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.AccessionDisplayView",
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

	public List<AccessionDisplayView> findByExample(
			AccessionDisplayView instance) {
		log.debug("finding AccessionDisplayView instance by example");
		try {
			List<AccessionDisplayView> results = (List<AccessionDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AccessionDisplayView")
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
