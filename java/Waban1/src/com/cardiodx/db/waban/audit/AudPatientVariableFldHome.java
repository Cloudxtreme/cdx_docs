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
 * Home object for domain model class AudPatientVariableFld.
 * @see com.cardiodx.db.waban.audit.AudPatientVariableFld
 * @author Hibernate Tools
 */
public class AudPatientVariableFldHome {

	private static final Log log = LogFactory
			.getLog(AudPatientVariableFldHome.class);

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

	public void persist(AudPatientVariableFld transientInstance) {
		log.debug("persisting AudPatientVariableFld instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudPatientVariableFld instance) {
		log.debug("attaching dirty AudPatientVariableFld instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudPatientVariableFld instance) {
		log.debug("attaching clean AudPatientVariableFld instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudPatientVariableFld persistentInstance) {
		log.debug("deleting AudPatientVariableFld instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudPatientVariableFld merge(AudPatientVariableFld detachedInstance) {
		log.debug("merging AudPatientVariableFld instance");
		try {
			AudPatientVariableFld result = (AudPatientVariableFld) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudPatientVariableFld findById(java.math.BigDecimal id) {
		log.debug("getting AudPatientVariableFld instance with id: " + id);
		try {
			AudPatientVariableFld instance = (AudPatientVariableFld) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudPatientVariableFld",
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

	public List<AudPatientVariableFld> findByExample(
			AudPatientVariableFld instance) {
		log.debug("finding AudPatientVariableFld instance by example");
		try {
			List<AudPatientVariableFld> results = (List<AudPatientVariableFld>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudPatientVariableFld")
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
