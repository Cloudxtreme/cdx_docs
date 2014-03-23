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
 * Home object for domain model class TraceTransfer.
 * @see com.cardiodx.db.waban.table.TraceTransfer
 * @author Hibernate Tools
 */
public class TraceTransferHome {

	private static final Log log = LogFactory.getLog(TraceTransferHome.class);

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

	public void persist(TraceTransfer transientInstance) {
		log.debug("persisting TraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TraceTransfer instance) {
		log.debug("attaching dirty TraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TraceTransfer instance) {
		log.debug("attaching clean TraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TraceTransfer persistentInstance) {
		log.debug("deleting TraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TraceTransfer merge(TraceTransfer detachedInstance) {
		log.debug("merging TraceTransfer instance");
		try {
			TraceTransfer result = (TraceTransfer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TraceTransfer findById(java.math.BigDecimal id) {
		log.debug("getting TraceTransfer instance with id: " + id);
		try {
			TraceTransfer instance = (TraceTransfer) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TraceTransfer", id);
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

	public List<TraceTransfer> findByExample(TraceTransfer instance) {
		log.debug("finding TraceTransfer instance by example");
		try {
			List<TraceTransfer> results = (List<TraceTransfer>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.TraceTransfer")
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
