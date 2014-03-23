package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudTraceTransfer.
 * @see com.cardiodx.db.waban.audit.AudTraceTransfer
 * @author Hibernate Tools
 */
public class AudTraceTransferHome {

	private static final Log log = LogFactory
			.getLog(AudTraceTransferHome.class);

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

	public void persist(AudTraceTransfer transientInstance) {
		log.debug("persisting AudTraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudTraceTransfer instance) {
		log.debug("attaching dirty AudTraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudTraceTransfer instance) {
		log.debug("attaching clean AudTraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudTraceTransfer persistentInstance) {
		log.debug("deleting AudTraceTransfer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudTraceTransfer merge(AudTraceTransfer detachedInstance) {
		log.debug("merging AudTraceTransfer instance");
		try {
			AudTraceTransfer result = (AudTraceTransfer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudTraceTransfer findById(java.math.BigDecimal id) {
		log.debug("getting AudTraceTransfer instance with id: " + id);
		try {
			AudTraceTransfer instance = (AudTraceTransfer) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudTraceTransfer", id);
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

	public List<AudTraceTransfer> findByExample(AudTraceTransfer instance) {
		log.debug("finding AudTraceTransfer instance by example");
		try {
			List<AudTraceTransfer> results = (List<AudTraceTransfer>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudTraceTransfer")
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
