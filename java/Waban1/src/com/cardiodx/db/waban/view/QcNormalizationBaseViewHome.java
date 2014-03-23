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
 * Home object for domain model class QcNormalizationBaseView.
 * @see com.cardiodx.db.waban.view.QcNormalizationBaseView
 * @author Hibernate Tools
 */
public class QcNormalizationBaseViewHome {

	private static final Log log = LogFactory
			.getLog(QcNormalizationBaseViewHome.class);

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

	public void persist(QcNormalizationBaseView transientInstance) {
		log.debug("persisting QcNormalizationBaseView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(QcNormalizationBaseView instance) {
		log.debug("attaching dirty QcNormalizationBaseView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(QcNormalizationBaseView instance) {
		log.debug("attaching clean QcNormalizationBaseView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(QcNormalizationBaseView persistentInstance) {
		log.debug("deleting QcNormalizationBaseView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public QcNormalizationBaseView merge(
			QcNormalizationBaseView detachedInstance) {
		log.debug("merging QcNormalizationBaseView instance");
		try {
			QcNormalizationBaseView result = (QcNormalizationBaseView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public QcNormalizationBaseView findById(
			com.cardiodx.db.waban.view.QcNormalizationBaseViewId id) {
		log.debug("getting QcNormalizationBaseView instance with id: " + id);
		try {
			QcNormalizationBaseView instance = (QcNormalizationBaseView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.QcNormalizationBaseView",
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

	public List<QcNormalizationBaseView> findByExample(
			QcNormalizationBaseView instance) {
		log.debug("finding QcNormalizationBaseView instance by example");
		try {
			List<QcNormalizationBaseView> results = (List<QcNormalizationBaseView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.QcNormalizationBaseView")
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
