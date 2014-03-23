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
 * Home object for domain model class ShippedSample.
 * @see com.cardiodx.db.waban.view.ShippedSample
 * @author Hibernate Tools
 */
public class ShippedSampleHome {

	private static final Log log = LogFactory.getLog(ShippedSampleHome.class);

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

	public void persist(ShippedSample transientInstance) {
		log.debug("persisting ShippedSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShippedSample instance) {
		log.debug("attaching dirty ShippedSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShippedSample instance) {
		log.debug("attaching clean ShippedSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShippedSample persistentInstance) {
		log.debug("deleting ShippedSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShippedSample merge(ShippedSample detachedInstance) {
		log.debug("merging ShippedSample instance");
		try {
			ShippedSample result = (ShippedSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShippedSample findById(com.cardiodx.db.waban.view.ShippedSampleId id) {
		log.debug("getting ShippedSample instance with id: " + id);
		try {
			ShippedSample instance = (ShippedSample) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ShippedSample", id);
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

	public List<ShippedSample> findByExample(ShippedSample instance) {
		log.debug("finding ShippedSample instance by example");
		try {
			List<ShippedSample> results = (List<ShippedSample>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.ShippedSample")
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
