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
 * Home object for domain model class AudOutboundRequest.
 * @see com.cardiodx.db.waban.audit.AudOutboundRequest
 * @author Hibernate Tools
 */
public class AudOutboundRequestHome {

	private static final Log log = LogFactory
			.getLog(AudOutboundRequestHome.class);

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

	public void persist(AudOutboundRequest transientInstance) {
		log.debug("persisting AudOutboundRequest instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudOutboundRequest instance) {
		log.debug("attaching dirty AudOutboundRequest instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudOutboundRequest instance) {
		log.debug("attaching clean AudOutboundRequest instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudOutboundRequest persistentInstance) {
		log.debug("deleting AudOutboundRequest instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudOutboundRequest merge(AudOutboundRequest detachedInstance) {
		log.debug("merging AudOutboundRequest instance");
		try {
			AudOutboundRequest result = (AudOutboundRequest) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudOutboundRequest findById(java.math.BigDecimal id) {
		log.debug("getting AudOutboundRequest instance with id: " + id);
		try {
			AudOutboundRequest instance = (AudOutboundRequest) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudOutboundRequest",
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

	public List<AudOutboundRequest> findByExample(AudOutboundRequest instance) {
		log.debug("finding AudOutboundRequest instance by example");
		try {
			List<AudOutboundRequest> results = (List<AudOutboundRequest>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudOutboundRequest")
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
