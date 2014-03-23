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
 * Home object for domain model class TraceTransferR.
 * @see com.cardiodx.db.waban.table.TraceTransferR
 * @author Hibernate Tools
 */
public class TraceTransferRHome {

	private static final Log log = LogFactory.getLog(TraceTransferRHome.class);

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

	public void persist(TraceTransferR transientInstance) {
		log.debug("persisting TraceTransferR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TraceTransferR instance) {
		log.debug("attaching dirty TraceTransferR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TraceTransferR instance) {
		log.debug("attaching clean TraceTransferR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TraceTransferR persistentInstance) {
		log.debug("deleting TraceTransferR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TraceTransferR merge(TraceTransferR detachedInstance) {
		log.debug("merging TraceTransferR instance");
		try {
			TraceTransferR result = (TraceTransferR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TraceTransferR findById(
			com.cardiodx.db.waban.table.TraceTransferRId id) {
		log.debug("getting TraceTransferR instance with id: " + id);
		try {
			TraceTransferR instance = (TraceTransferR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TraceTransferR", id);
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

	public List<TraceTransferR> findByExample(TraceTransferR instance) {
		log.debug("finding TraceTransferR instance by example");
		try {
			List<TraceTransferR> results = (List<TraceTransferR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TraceTransferR")
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
