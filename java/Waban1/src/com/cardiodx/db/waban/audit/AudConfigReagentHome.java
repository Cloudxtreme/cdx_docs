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
 * Home object for domain model class AudConfigReagent.
 * @see com.cardiodx.db.waban.audit.AudConfigReagent
 * @author Hibernate Tools
 */
public class AudConfigReagentHome {

	private static final Log log = LogFactory
			.getLog(AudConfigReagentHome.class);

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

	public void persist(AudConfigReagent transientInstance) {
		log.debug("persisting AudConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudConfigReagent instance) {
		log.debug("attaching dirty AudConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudConfigReagent instance) {
		log.debug("attaching clean AudConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudConfigReagent persistentInstance) {
		log.debug("deleting AudConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudConfigReagent merge(AudConfigReagent detachedInstance) {
		log.debug("merging AudConfigReagent instance");
		try {
			AudConfigReagent result = (AudConfigReagent) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudConfigReagent findById(java.math.BigDecimal id) {
		log.debug("getting AudConfigReagent instance with id: " + id);
		try {
			AudConfigReagent instance = (AudConfigReagent) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudConfigReagent", id);
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

	public List<AudConfigReagent> findByExample(AudConfigReagent instance) {
		log.debug("finding AudConfigReagent instance by example");
		try {
			List<AudConfigReagent> results = (List<AudConfigReagent>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudConfigReagent")
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
