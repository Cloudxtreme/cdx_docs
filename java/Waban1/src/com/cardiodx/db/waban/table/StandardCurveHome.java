package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class StandardCurve.
 * @see com.cardiodx.db.waban.table.StandardCurve
 * @author Hibernate Tools
 */
public class StandardCurveHome {

	private static final Log log = LogFactory.getLog(StandardCurveHome.class);

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

	public void persist(StandardCurve transientInstance) {
		log.debug("persisting StandardCurve instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StandardCurve instance) {
		log.debug("attaching dirty StandardCurve instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StandardCurve instance) {
		log.debug("attaching clean StandardCurve instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StandardCurve persistentInstance) {
		log.debug("deleting StandardCurve instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StandardCurve merge(StandardCurve detachedInstance) {
		log.debug("merging StandardCurve instance");
		try {
			StandardCurve result = (StandardCurve) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StandardCurve findById(java.math.BigDecimal id) {
		log.debug("getting StandardCurve instance with id: " + id);
		try {
			StandardCurve instance = (StandardCurve) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.StandardCurve", id);
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

	public List<StandardCurve> findByExample(StandardCurve instance) {
		log.debug("finding StandardCurve instance by example");
		try {
			List<StandardCurve> results = (List<StandardCurve>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.StandardCurve")
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
