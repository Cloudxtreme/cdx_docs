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
 * Home object for domain model class OligoTemplateInfoView.
 * @see com.cardiodx.db.waban.view.OligoTemplateInfoView
 * @author Hibernate Tools
 */
public class OligoTemplateInfoViewHome {

	private static final Log log = LogFactory
			.getLog(OligoTemplateInfoViewHome.class);

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

	public void persist(OligoTemplateInfoView transientInstance) {
		log.debug("persisting OligoTemplateInfoView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoTemplateInfoView instance) {
		log.debug("attaching dirty OligoTemplateInfoView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoTemplateInfoView instance) {
		log.debug("attaching clean OligoTemplateInfoView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoTemplateInfoView persistentInstance) {
		log.debug("deleting OligoTemplateInfoView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoTemplateInfoView merge(OligoTemplateInfoView detachedInstance) {
		log.debug("merging OligoTemplateInfoView instance");
		try {
			OligoTemplateInfoView result = (OligoTemplateInfoView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoTemplateInfoView findById(
			com.cardiodx.db.waban.view.OligoTemplateInfoViewId id) {
		log.debug("getting OligoTemplateInfoView instance with id: " + id);
		try {
			OligoTemplateInfoView instance = (OligoTemplateInfoView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.OligoTemplateInfoView",
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

	public List<OligoTemplateInfoView> findByExample(
			OligoTemplateInfoView instance) {
		log.debug("finding OligoTemplateInfoView instance by example");
		try {
			List<OligoTemplateInfoView> results = (List<OligoTemplateInfoView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.OligoTemplateInfoView")
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
