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
 * Home object for domain model class AnonymizationRequestView.
 * @see com.cardiodx.db.waban.view.AnonymizationRequestView
 * @author Hibernate Tools
 */
public class AnonymizationRequestViewHome {

	private static final Log log = LogFactory
			.getLog(AnonymizationRequestViewHome.class);

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

	public void persist(AnonymizationRequestView transientInstance) {
		log.debug("persisting AnonymizationRequestView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizationRequestView instance) {
		log.debug("attaching dirty AnonymizationRequestView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizationRequestView instance) {
		log.debug("attaching clean AnonymizationRequestView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizationRequestView persistentInstance) {
		log.debug("deleting AnonymizationRequestView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizationRequestView merge(
			AnonymizationRequestView detachedInstance) {
		log.debug("merging AnonymizationRequestView instance");
		try {
			AnonymizationRequestView result = (AnonymizationRequestView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizationRequestView findById(
			com.cardiodx.db.waban.view.AnonymizationRequestViewId id) {
		log.debug("getting AnonymizationRequestView instance with id: " + id);
		try {
			AnonymizationRequestView instance = (AnonymizationRequestView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.AnonymizationRequestView",
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

	public List<AnonymizationRequestView> findByExample(
			AnonymizationRequestView instance) {
		log.debug("finding AnonymizationRequestView instance by example");
		try {
			List<AnonymizationRequestView> results = (List<AnonymizationRequestView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AnonymizationRequestView")
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
