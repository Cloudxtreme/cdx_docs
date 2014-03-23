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
 * Home object for domain model class StandardCurveR.
 * @see com.cardiodx.db.waban.table.StandardCurveR
 * @author Hibernate Tools
 */
public class StandardCurveRHome {

	private static final Log log = LogFactory.getLog(StandardCurveRHome.class);

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

	public void persist(StandardCurveR transientInstance) {
		log.debug("persisting StandardCurveR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StandardCurveR instance) {
		log.debug("attaching dirty StandardCurveR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StandardCurveR instance) {
		log.debug("attaching clean StandardCurveR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StandardCurveR persistentInstance) {
		log.debug("deleting StandardCurveR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StandardCurveR merge(StandardCurveR detachedInstance) {
		log.debug("merging StandardCurveR instance");
		try {
			StandardCurveR result = (StandardCurveR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StandardCurveR findById(
			com.cardiodx.db.waban.table.StandardCurveRId id) {
		log.debug("getting StandardCurveR instance with id: " + id);
		try {
			StandardCurveR instance = (StandardCurveR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.StandardCurveR", id);
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

	public List<StandardCurveR> findByExample(StandardCurveR instance) {
		log.debug("finding StandardCurveR instance by example");
		try {
			List<StandardCurveR> results = (List<StandardCurveR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.StandardCurveR")
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
