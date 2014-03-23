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
 * Home object for domain model class AudWordreportParam.
 * @see com.cardiodx.db.waban.audit.AudWordreportParam
 * @author Hibernate Tools
 */
public class AudWordreportParamHome {

	private static final Log log = LogFactory
			.getLog(AudWordreportParamHome.class);

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

	public void persist(AudWordreportParam transientInstance) {
		log.debug("persisting AudWordreportParam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudWordreportParam instance) {
		log.debug("attaching dirty AudWordreportParam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudWordreportParam instance) {
		log.debug("attaching clean AudWordreportParam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudWordreportParam persistentInstance) {
		log.debug("deleting AudWordreportParam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudWordreportParam merge(AudWordreportParam detachedInstance) {
		log.debug("merging AudWordreportParam instance");
		try {
			AudWordreportParam result = (AudWordreportParam) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudWordreportParam findById(java.math.BigDecimal id) {
		log.debug("getting AudWordreportParam instance with id: " + id);
		try {
			AudWordreportParam instance = (AudWordreportParam) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudWordreportParam",
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

	public List<AudWordreportParam> findByExample(AudWordreportParam instance) {
		log.debug("finding AudWordreportParam instance by example");
		try {
			List<AudWordreportParam> results = (List<AudWordreportParam>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudWordreportParam")
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
