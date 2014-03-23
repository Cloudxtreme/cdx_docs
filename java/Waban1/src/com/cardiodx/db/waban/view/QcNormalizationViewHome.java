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
 * Home object for domain model class QcNormalizationView.
 * @see com.cardiodx.db.waban.view.QcNormalizationView
 * @author Hibernate Tools
 */
public class QcNormalizationViewHome {

	private static final Log log = LogFactory
			.getLog(QcNormalizationViewHome.class);

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

	public void persist(QcNormalizationView transientInstance) {
		log.debug("persisting QcNormalizationView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QcNormalizationView instance) {
		log.debug("attaching dirty QcNormalizationView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QcNormalizationView instance) {
		log.debug("attaching clean QcNormalizationView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QcNormalizationView persistentInstance) {
		log.debug("deleting QcNormalizationView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QcNormalizationView merge(QcNormalizationView detachedInstance) {
		log.debug("merging QcNormalizationView instance");
		try {
			QcNormalizationView result = (QcNormalizationView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QcNormalizationView findById(
			com.cardiodx.db.waban.view.QcNormalizationViewId id) {
		log.debug("getting QcNormalizationView instance with id: " + id);
		try {
			QcNormalizationView instance = (QcNormalizationView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.QcNormalizationView",
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

	public List<QcNormalizationView> findByExample(QcNormalizationView instance) {
		log.debug("finding QcNormalizationView instance by example");
		try {
			List<QcNormalizationView> results = (List<QcNormalizationView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.QcNormalizationView")
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
