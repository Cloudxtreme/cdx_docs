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
 * Home object for domain model class AudShipmentAirbillR.
 * @see com.cardiodx.db.waban.audit.AudShipmentAirbillR
 * @author Hibernate Tools
 */
public class AudShipmentAirbillRHome {

	private static final Log log = LogFactory
			.getLog(AudShipmentAirbillRHome.class);

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

	public void persist(AudShipmentAirbillR transientInstance) {
		log.debug("persisting AudShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudShipmentAirbillR instance) {
		log.debug("attaching dirty AudShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudShipmentAirbillR instance) {
		log.debug("attaching clean AudShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudShipmentAirbillR persistentInstance) {
		log.debug("deleting AudShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudShipmentAirbillR merge(AudShipmentAirbillR detachedInstance) {
		log.debug("merging AudShipmentAirbillR instance");
		try {
			AudShipmentAirbillR result = (AudShipmentAirbillR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudShipmentAirbillR findById(
			com.cardiodx.db.waban.audit.AudShipmentAirbillRId id) {
		log.debug("getting AudShipmentAirbillR instance with id: " + id);
		try {
			AudShipmentAirbillR instance = (AudShipmentAirbillR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudShipmentAirbillR",
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

	public List<AudShipmentAirbillR> findByExample(AudShipmentAirbillR instance) {
		log.debug("finding AudShipmentAirbillR instance by example");
		try {
			List<AudShipmentAirbillR> results = (List<AudShipmentAirbillR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudShipmentAirbillR")
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
