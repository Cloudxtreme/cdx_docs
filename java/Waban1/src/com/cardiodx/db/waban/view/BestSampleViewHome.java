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
 * Home object for domain model class BestSampleView.
 * @see com.cardiodx.db.waban.view.BestSampleView
 * @author Hibernate Tools
 */
public class BestSampleViewHome {

	private static final Log log = LogFactory.getLog(BestSampleViewHome.class);

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

	public void persist(BestSampleView transientInstance) {
		log.debug("persisting BestSampleView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BestSampleView instance) {
		log.debug("attaching dirty BestSampleView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BestSampleView instance) {
		log.debug("attaching clean BestSampleView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BestSampleView persistentInstance) {
		log.debug("deleting BestSampleView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BestSampleView merge(BestSampleView detachedInstance) {
		log.debug("merging BestSampleView instance");
		try {
			BestSampleView result = (BestSampleView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BestSampleView findById(
			com.cardiodx.db.waban.view.BestSampleViewId id) {
		log.debug("getting BestSampleView instance with id: " + id);
		try {
			BestSampleView instance = (BestSampleView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.BestSampleView", id);
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

	public List<BestSampleView> findByExample(BestSampleView instance) {
		log.debug("finding BestSampleView instance by example");
		try {
			List<BestSampleView> results = (List<BestSampleView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.BestSampleView")
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
