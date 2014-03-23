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
 * Home object for domain model class AudAccessionVariableFld.
 * @see com.cardiodx.db.waban.audit.AudAccessionVariableFld
 * @author Hibernate Tools
 */
public class AudAccessionVariableFldHome {

	private static final Log log = LogFactory
			.getLog(AudAccessionVariableFldHome.class);

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

	public void persist(AudAccessionVariableFld transientInstance) {
		log.debug("persisting AudAccessionVariableFld instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudAccessionVariableFld instance) {
		log.debug("attaching dirty AudAccessionVariableFld instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudAccessionVariableFld instance) {
		log.debug("attaching clean AudAccessionVariableFld instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudAccessionVariableFld persistentInstance) {
		log.debug("deleting AudAccessionVariableFld instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudAccessionVariableFld merge(
			AudAccessionVariableFld detachedInstance) {
		log.debug("merging AudAccessionVariableFld instance");
		try {
			AudAccessionVariableFld result = (AudAccessionVariableFld) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudAccessionVariableFld findById(java.math.BigDecimal id) {
		log.debug("getting AudAccessionVariableFld instance with id: " + id);
		try {
			AudAccessionVariableFld instance = (AudAccessionVariableFld) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudAccessionVariableFld",
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

	public List<AudAccessionVariableFld> findByExample(
			AudAccessionVariableFld instance) {
		log.debug("finding AudAccessionVariableFld instance by example");
		try {
			List<AudAccessionVariableFld> results = (List<AudAccessionVariableFld>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudAccessionVariableFld")
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
