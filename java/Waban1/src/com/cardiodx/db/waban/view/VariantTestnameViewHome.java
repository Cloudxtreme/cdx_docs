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
 * Home object for domain model class VariantTestnameView.
 * @see com.cardiodx.db.waban.view.VariantTestnameView
 * @author Hibernate Tools
 */
public class VariantTestnameViewHome {

	private static final Log log = LogFactory
			.getLog(VariantTestnameViewHome.class);

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

	public void persist(VariantTestnameView transientInstance) {
		log.debug("persisting VariantTestnameView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariantTestnameView instance) {
		log.debug("attaching dirty VariantTestnameView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariantTestnameView instance) {
		log.debug("attaching clean VariantTestnameView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariantTestnameView persistentInstance) {
		log.debug("deleting VariantTestnameView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariantTestnameView merge(VariantTestnameView detachedInstance) {
		log.debug("merging VariantTestnameView instance");
		try {
			VariantTestnameView result = (VariantTestnameView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariantTestnameView findById(
			com.cardiodx.db.waban.view.VariantTestnameViewId id) {
		log.debug("getting VariantTestnameView instance with id: " + id);
		try {
			VariantTestnameView instance = (VariantTestnameView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.VariantTestnameView",
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

	public List<VariantTestnameView> findByExample(VariantTestnameView instance) {
		log.debug("finding VariantTestnameView instance by example");
		try {
			List<VariantTestnameView> results = (List<VariantTestnameView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VariantTestnameView")
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
