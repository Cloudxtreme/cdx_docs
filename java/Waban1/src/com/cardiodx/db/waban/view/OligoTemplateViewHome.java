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
 * Home object for domain model class OligoTemplateView.
 * @see com.cardiodx.db.waban.view.OligoTemplateView
 * @author Hibernate Tools
 */
public class OligoTemplateViewHome {

	private static final Log log = LogFactory
			.getLog(OligoTemplateViewHome.class);

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

	public void persist(OligoTemplateView transientInstance) {
		log.debug("persisting OligoTemplateView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoTemplateView instance) {
		log.debug("attaching dirty OligoTemplateView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoTemplateView instance) {
		log.debug("attaching clean OligoTemplateView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoTemplateView persistentInstance) {
		log.debug("deleting OligoTemplateView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoTemplateView merge(OligoTemplateView detachedInstance) {
		log.debug("merging OligoTemplateView instance");
		try {
			OligoTemplateView result = (OligoTemplateView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoTemplateView findById(
			com.cardiodx.db.waban.view.OligoTemplateViewId id) {
		log.debug("getting OligoTemplateView instance with id: " + id);
		try {
			OligoTemplateView instance = (OligoTemplateView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.OligoTemplateView", id);
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

	public List<OligoTemplateView> findByExample(OligoTemplateView instance) {
		log.debug("finding OligoTemplateView instance by example");
		try {
			List<OligoTemplateView> results = (List<OligoTemplateView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.OligoTemplateView")
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
