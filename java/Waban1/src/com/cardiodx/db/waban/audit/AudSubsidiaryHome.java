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
 * Home object for domain model class AudSubsidiary.
 * @see com.cardiodx.db.waban.audit.AudSubsidiary
 * @author Hibernate Tools
 */
public class AudSubsidiaryHome {

	private static final Log log = LogFactory.getLog(AudSubsidiaryHome.class);

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

	public void persist(AudSubsidiary transientInstance) {
		log.debug("persisting AudSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSubsidiary instance) {
		log.debug("attaching dirty AudSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSubsidiary instance) {
		log.debug("attaching clean AudSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSubsidiary persistentInstance) {
		log.debug("deleting AudSubsidiary instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSubsidiary merge(AudSubsidiary detachedInstance) {
		log.debug("merging AudSubsidiary instance");
		try {
			AudSubsidiary result = (AudSubsidiary) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSubsidiary findById(java.math.BigDecimal id) {
		log.debug("getting AudSubsidiary instance with id: " + id);
		try {
			AudSubsidiary instance = (AudSubsidiary) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudSubsidiary", id);
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

	public List<AudSubsidiary> findByExample(AudSubsidiary instance) {
		log.debug("finding AudSubsidiary instance by example");
		try {
			List<AudSubsidiary> results = (List<AudSubsidiary>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudSubsidiary")
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
