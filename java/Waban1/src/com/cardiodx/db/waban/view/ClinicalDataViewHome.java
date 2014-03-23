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
 * Home object for domain model class ClinicalDataView.
 * @see com.cardiodx.db.waban.view.ClinicalDataView
 * @author Hibernate Tools
 */
public class ClinicalDataViewHome {

	private static final Log log = LogFactory
			.getLog(ClinicalDataViewHome.class);

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

	public void persist(ClinicalDataView transientInstance) {
		log.debug("persisting ClinicalDataView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ClinicalDataView instance) {
		log.debug("attaching dirty ClinicalDataView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ClinicalDataView instance) {
		log.debug("attaching clean ClinicalDataView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ClinicalDataView persistentInstance) {
		log.debug("deleting ClinicalDataView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ClinicalDataView merge(ClinicalDataView detachedInstance) {
		log.debug("merging ClinicalDataView instance");
		try {
			ClinicalDataView result = (ClinicalDataView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ClinicalDataView findById(
			com.cardiodx.db.waban.view.ClinicalDataViewId id) {
		log.debug("getting ClinicalDataView instance with id: " + id);
		try {
			ClinicalDataView instance = (ClinicalDataView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ClinicalDataView", id);
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

	public List<ClinicalDataView> findByExample(ClinicalDataView instance) {
		log.debug("finding ClinicalDataView instance by example");
		try {
			List<ClinicalDataView> results = (List<ClinicalDataView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ClinicalDataView")
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
