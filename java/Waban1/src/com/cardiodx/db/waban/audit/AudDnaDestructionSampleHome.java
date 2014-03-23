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
 * Home object for domain model class AudDnaDestructionSample.
 * @see com.cardiodx.db.waban.audit.AudDnaDestructionSample
 * @author Hibernate Tools
 */
public class AudDnaDestructionSampleHome {

	private static final Log log = LogFactory
			.getLog(AudDnaDestructionSampleHome.class);

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

	public void persist(AudDnaDestructionSample transientInstance) {
		log.debug("persisting AudDnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudDnaDestructionSample instance) {
		log.debug("attaching dirty AudDnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudDnaDestructionSample instance) {
		log.debug("attaching clean AudDnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudDnaDestructionSample persistentInstance) {
		log.debug("deleting AudDnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudDnaDestructionSample merge(
			AudDnaDestructionSample detachedInstance) {
		log.debug("merging AudDnaDestructionSample instance");
		try {
			AudDnaDestructionSample result = (AudDnaDestructionSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudDnaDestructionSample findById(java.math.BigDecimal id) {
		log.debug("getting AudDnaDestructionSample instance with id: " + id);
		try {
			AudDnaDestructionSample instance = (AudDnaDestructionSample) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudDnaDestructionSample",
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

	public List<AudDnaDestructionSample> findByExample(
			AudDnaDestructionSample instance) {
		log.debug("finding AudDnaDestructionSample instance by example");
		try {
			List<AudDnaDestructionSample> results = (List<AudDnaDestructionSample>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudDnaDestructionSample")
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
