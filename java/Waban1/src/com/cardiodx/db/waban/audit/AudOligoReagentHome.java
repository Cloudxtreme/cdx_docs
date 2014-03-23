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
 * Home object for domain model class AudOligoReagent.
 * @see com.cardiodx.db.waban.audit.AudOligoReagent
 * @author Hibernate Tools
 */
public class AudOligoReagentHome {

	private static final Log log = LogFactory.getLog(AudOligoReagentHome.class);

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

	public void persist(AudOligoReagent transientInstance) {
		log.debug("persisting AudOligoReagent instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudOligoReagent instance) {
		log.debug("attaching dirty AudOligoReagent instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudOligoReagent instance) {
		log.debug("attaching clean AudOligoReagent instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudOligoReagent persistentInstance) {
		log.debug("deleting AudOligoReagent instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudOligoReagent merge(AudOligoReagent detachedInstance) {
		log.debug("merging AudOligoReagent instance");
		try {
			AudOligoReagent result = (AudOligoReagent) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudOligoReagent findById(java.math.BigDecimal id) {
		log.debug("getting AudOligoReagent instance with id: " + id);
		try {
			AudOligoReagent instance = (AudOligoReagent) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudOligoReagent", id);
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

	public List<AudOligoReagent> findByExample(AudOligoReagent instance) {
		log.debug("finding AudOligoReagent instance by example");
		try {
			List<AudOligoReagent> results = (List<AudOligoReagent>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudOligoReagent")
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
