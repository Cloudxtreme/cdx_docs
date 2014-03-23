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
 * Home object for domain model class AudUserSubsidiary.
 * @see com.cardiodx.db.waban.audit.AudUserSubsidiary
 * @author Hibernate Tools
 */
public class AudUserSubsidiaryHome {

	private static final Log log = LogFactory
			.getLog(AudUserSubsidiaryHome.class);

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

	public void persist(AudUserSubsidiary transientInstance) {
		log.debug("persisting AudUserSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudUserSubsidiary instance) {
		log.debug("attaching dirty AudUserSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudUserSubsidiary instance) {
		log.debug("attaching clean AudUserSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudUserSubsidiary persistentInstance) {
		log.debug("deleting AudUserSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudUserSubsidiary merge(AudUserSubsidiary detachedInstance) {
		log.debug("merging AudUserSubsidiary instance");
		try {
			AudUserSubsidiary result = (AudUserSubsidiary) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudUserSubsidiary findById(java.math.BigDecimal id) {
		log.debug("getting AudUserSubsidiary instance with id: " + id);
		try {
			AudUserSubsidiary instance = (AudUserSubsidiary) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudUserSubsidiary", id);
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

	public List<AudUserSubsidiary> findByExample(AudUserSubsidiary instance) {
		log.debug("finding AudUserSubsidiary instance by example");
		try {
			List<AudUserSubsidiary> results = (List<AudUserSubsidiary>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudUserSubsidiary")
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
