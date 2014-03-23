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
 * Home object for domain model class AudDnaDestructionRequest.
 * @see com.cardiodx.db.waban.audit.AudDnaDestructionRequest
 * @author Hibernate Tools
 */
public class AudDnaDestructionRequestHome {

	private static final Log log = LogFactory
			.getLog(AudDnaDestructionRequestHome.class);

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

	public void persist(AudDnaDestructionRequest transientInstance) {
		log.debug("persisting AudDnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudDnaDestructionRequest instance) {
		log.debug("attaching dirty AudDnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudDnaDestructionRequest instance) {
		log.debug("attaching clean AudDnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudDnaDestructionRequest persistentInstance) {
		log.debug("deleting AudDnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudDnaDestructionRequest merge(
			AudDnaDestructionRequest detachedInstance) {
		log.debug("merging AudDnaDestructionRequest instance");
		try {
			AudDnaDestructionRequest result = (AudDnaDestructionRequest) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudDnaDestructionRequest findById(java.math.BigDecimal id) {
		log.debug("getting AudDnaDestructionRequest instance with id: " + id);
		try {
			AudDnaDestructionRequest instance = (AudDnaDestructionRequest) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudDnaDestructionRequest",
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

	public List<AudDnaDestructionRequest> findByExample(
			AudDnaDestructionRequest instance) {
		log.debug("finding AudDnaDestructionRequest instance by example");
		try {
			List<AudDnaDestructionRequest> results = (List<AudDnaDestructionRequest>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudDnaDestructionRequest")
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
