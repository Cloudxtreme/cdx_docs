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
 * Home object for domain model class TraceQc.
 * @see com.cardiodx.db.waban.table.TraceQc
 * @author Hibernate Tools
 */
public class TraceQcHome {

	private static final Log log = LogFactory.getLog(TraceQcHome.class);

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

	public void persist(TraceQc transientInstance) {
		log.debug("persisting TraceQc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TraceQc instance) {
		log.debug("attaching dirty TraceQc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TraceQc instance) {
		log.debug("attaching clean TraceQc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TraceQc persistentInstance) {
		log.debug("deleting TraceQc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TraceQc merge(TraceQc detachedInstance) {
		log.debug("merging TraceQc instance");
		try {
			TraceQc result = (TraceQc) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TraceQc findById(java.math.BigDecimal id) {
		log.debug("getting TraceQc instance with id: " + id);
		try {
			TraceQc instance = (TraceQc) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.TraceQc", id);
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

	public List<TraceQc> findByExample(TraceQc instance) {
		log.debug("finding TraceQc instance by example");
		try {
			List<TraceQc> results = (List<TraceQc>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.TraceQc")
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
