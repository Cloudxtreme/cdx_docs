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
 * Home object for domain model class AudTraceTransferAttribR.
 * @see com.cardiodx.db.waban.audit.AudTraceTransferAttribR
 * @author Hibernate Tools
 */
public class AudTraceTransferAttribRHome {

	private static final Log log = LogFactory
			.getLog(AudTraceTransferAttribRHome.class);

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

	public void persist(AudTraceTransferAttribR transientInstance) {
		log.debug("persisting AudTraceTransferAttribR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudTraceTransferAttribR instance) {
		log.debug("attaching dirty AudTraceTransferAttribR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudTraceTransferAttribR instance) {
		log.debug("attaching clean AudTraceTransferAttribR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudTraceTransferAttribR persistentInstance) {
		log.debug("deleting AudTraceTransferAttribR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudTraceTransferAttribR merge(
			AudTraceTransferAttribR detachedInstance) {
		log.debug("merging AudTraceTransferAttribR instance");
		try {
			AudTraceTransferAttribR result = (AudTraceTransferAttribR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudTraceTransferAttribR findById(
			com.cardiodx.db.waban.audit.AudTraceTransferAttribRId id) {
		log.debug("getting AudTraceTransferAttribR instance with id: " + id);
		try {
			AudTraceTransferAttribR instance = (AudTraceTransferAttribR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudTraceTransferAttribR",
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

	public List<AudTraceTransferAttribR> findByExample(
			AudTraceTransferAttribR instance) {
		log.debug("finding AudTraceTransferAttribR instance by example");
		try {
			List<AudTraceTransferAttribR> results = (List<AudTraceTransferAttribR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudTraceTransferAttribR")
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
