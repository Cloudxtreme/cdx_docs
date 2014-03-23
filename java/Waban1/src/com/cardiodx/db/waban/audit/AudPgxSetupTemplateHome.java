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
 * Home object for domain model class AudPgxSetupTemplate.
 * @see com.cardiodx.db.waban.audit.AudPgxSetupTemplate
 * @author Hibernate Tools
 */
public class AudPgxSetupTemplateHome {

	private static final Log log = LogFactory
			.getLog(AudPgxSetupTemplateHome.class);

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

	public void persist(AudPgxSetupTemplate transientInstance) {
		log.debug("persisting AudPgxSetupTemplate instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudPgxSetupTemplate instance) {
		log.debug("attaching dirty AudPgxSetupTemplate instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudPgxSetupTemplate instance) {
		log.debug("attaching clean AudPgxSetupTemplate instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudPgxSetupTemplate persistentInstance) {
		log.debug("deleting AudPgxSetupTemplate instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudPgxSetupTemplate merge(AudPgxSetupTemplate detachedInstance) {
		log.debug("merging AudPgxSetupTemplate instance");
		try {
			AudPgxSetupTemplate result = (AudPgxSetupTemplate) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudPgxSetupTemplate findById(java.math.BigDecimal id) {
		log.debug("getting AudPgxSetupTemplate instance with id: " + id);
		try {
			AudPgxSetupTemplate instance = (AudPgxSetupTemplate) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudPgxSetupTemplate",
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

	public List<AudPgxSetupTemplate> findByExample(AudPgxSetupTemplate instance) {
		log.debug("finding AudPgxSetupTemplate instance by example");
		try {
			List<AudPgxSetupTemplate> results = (List<AudPgxSetupTemplate>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudPgxSetupTemplate")
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
