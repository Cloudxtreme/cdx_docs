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
 * Home object for domain model class AudMaintenanceSchedule.
 * @see com.cardiodx.db.waban.audit.AudMaintenanceSchedule
 * @author Hibernate Tools
 */
public class AudMaintenanceScheduleHome {

	private static final Log log = LogFactory
			.getLog(AudMaintenanceScheduleHome.class);

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

	public void persist(AudMaintenanceSchedule transientInstance) {
		log.debug("persisting AudMaintenanceSchedule instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudMaintenanceSchedule instance) {
		log.debug("attaching dirty AudMaintenanceSchedule instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudMaintenanceSchedule instance) {
		log.debug("attaching clean AudMaintenanceSchedule instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudMaintenanceSchedule persistentInstance) {
		log.debug("deleting AudMaintenanceSchedule instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudMaintenanceSchedule merge(AudMaintenanceSchedule detachedInstance) {
		log.debug("merging AudMaintenanceSchedule instance");
		try {
			AudMaintenanceSchedule result = (AudMaintenanceSchedule) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudMaintenanceSchedule findById(java.math.BigDecimal id) {
		log.debug("getting AudMaintenanceSchedule instance with id: " + id);
		try {
			AudMaintenanceSchedule instance = (AudMaintenanceSchedule) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudMaintenanceSchedule",
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

	public List<AudMaintenanceSchedule> findByExample(
			AudMaintenanceSchedule instance) {
		log.debug("finding AudMaintenanceSchedule instance by example");
		try {
			List<AudMaintenanceSchedule> results = (List<AudMaintenanceSchedule>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudMaintenanceSchedule")
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
