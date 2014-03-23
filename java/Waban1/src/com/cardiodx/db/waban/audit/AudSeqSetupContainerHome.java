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
 * Home object for domain model class AudSeqSetupContainer.
 * @see com.cardiodx.db.waban.audit.AudSeqSetupContainer
 * @author Hibernate Tools
 */
public class AudSeqSetupContainerHome {

	private static final Log log = LogFactory
			.getLog(AudSeqSetupContainerHome.class);

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

	public void persist(AudSeqSetupContainer transientInstance) {
		log.debug("persisting AudSeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSeqSetupContainer instance) {
		log.debug("attaching dirty AudSeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSeqSetupContainer instance) {
		log.debug("attaching clean AudSeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSeqSetupContainer persistentInstance) {
		log.debug("deleting AudSeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSeqSetupContainer merge(AudSeqSetupContainer detachedInstance) {
		log.debug("merging AudSeqSetupContainer instance");
		try {
			AudSeqSetupContainer result = (AudSeqSetupContainer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSeqSetupContainer findById(java.math.BigDecimal id) {
		log.debug("getting AudSeqSetupContainer instance with id: " + id);
		try {
			AudSeqSetupContainer instance = (AudSeqSetupContainer) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudSeqSetupContainer",
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

	public List<AudSeqSetupContainer> findByExample(
			AudSeqSetupContainer instance) {
		log.debug("finding AudSeqSetupContainer instance by example");
		try {
			List<AudSeqSetupContainer> results = (List<AudSeqSetupContainer>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudSeqSetupContainer")
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
