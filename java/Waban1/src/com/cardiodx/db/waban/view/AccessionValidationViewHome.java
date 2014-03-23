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
 * Home object for domain model class AccessionValidationView.
 * @see com.cardiodx.db.waban.view.AccessionValidationView
 * @author Hibernate Tools
 */
public class AccessionValidationViewHome {

	private static final Log log = LogFactory
			.getLog(AccessionValidationViewHome.class);

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

	public void persist(AccessionValidationView transientInstance) {
		log.debug("persisting AccessionValidationView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AccessionValidationView instance) {
		log.debug("attaching dirty AccessionValidationView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccessionValidationView instance) {
		log.debug("attaching clean AccessionValidationView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AccessionValidationView persistentInstance) {
		log.debug("deleting AccessionValidationView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccessionValidationView merge(
			AccessionValidationView detachedInstance) {
		log.debug("merging AccessionValidationView instance");
		try {
			AccessionValidationView result = (AccessionValidationView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AccessionValidationView findById(
			com.cardiodx.db.waban.view.AccessionValidationViewId id) {
		log.debug("getting AccessionValidationView instance with id: " + id);
		try {
			AccessionValidationView instance = (AccessionValidationView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.AccessionValidationView",
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

	public List<AccessionValidationView> findByExample(
			AccessionValidationView instance) {
		log.debug("finding AccessionValidationView instance by example");
		try {
			List<AccessionValidationView> results = (List<AccessionValidationView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AccessionValidationView")
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