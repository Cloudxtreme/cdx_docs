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
 * Home object for domain model class DilutionView.
 * @see com.cardiodx.db.waban.view.DilutionView
 * @author Hibernate Tools
 */
public class DilutionViewHome {

	private static final Log log = LogFactory.getLog(DilutionViewHome.class);

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

	public void persist(DilutionView transientInstance) {
		log.debug("persisting DilutionView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DilutionView instance) {
		log.debug("attaching dirty DilutionView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DilutionView instance) {
		log.debug("attaching clean DilutionView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DilutionView persistentInstance) {
		log.debug("deleting DilutionView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DilutionView merge(DilutionView detachedInstance) {
		log.debug("merging DilutionView instance");
		try {
			DilutionView result = (DilutionView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DilutionView findById(com.cardiodx.db.waban.view.DilutionViewId id) {
		log.debug("getting DilutionView instance with id: " + id);
		try {
			DilutionView instance = (DilutionView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.DilutionView", id);
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

	public List<DilutionView> findByExample(DilutionView instance) {
		log.debug("finding DilutionView instance by example");
		try {
			List<DilutionView> results = (List<DilutionView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.DilutionView")
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
