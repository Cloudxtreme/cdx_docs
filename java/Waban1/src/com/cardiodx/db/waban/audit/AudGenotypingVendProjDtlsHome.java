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
 * Home object for domain model class AudGenotypingVendProjDtls.
 * @see com.cardiodx.db.waban.audit.AudGenotypingVendProjDtls
 * @author Hibernate Tools
 */
public class AudGenotypingVendProjDtlsHome {

	private static final Log log = LogFactory
			.getLog(AudGenotypingVendProjDtlsHome.class);

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

	public void persist(AudGenotypingVendProjDtls transientInstance) {
		log.debug("persisting AudGenotypingVendProjDtls instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudGenotypingVendProjDtls instance) {
		log.debug("attaching dirty AudGenotypingVendProjDtls instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudGenotypingVendProjDtls instance) {
		log.debug("attaching clean AudGenotypingVendProjDtls instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudGenotypingVendProjDtls persistentInstance) {
		log.debug("deleting AudGenotypingVendProjDtls instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudGenotypingVendProjDtls merge(
			AudGenotypingVendProjDtls detachedInstance) {
		log.debug("merging AudGenotypingVendProjDtls instance");
		try {
			AudGenotypingVendProjDtls result = (AudGenotypingVendProjDtls) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudGenotypingVendProjDtls findById(java.math.BigDecimal id) {
		log.debug("getting AudGenotypingVendProjDtls instance with id: " + id);
		try {
			AudGenotypingVendProjDtls instance = (AudGenotypingVendProjDtls) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudGenotypingVendProjDtls",
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

	public List<AudGenotypingVendProjDtls> findByExample(
			AudGenotypingVendProjDtls instance) {
		log.debug("finding AudGenotypingVendProjDtls instance by example");
		try {
			List<AudGenotypingVendProjDtls> results = (List<AudGenotypingVendProjDtls>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudGenotypingVendProjDtls")
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
