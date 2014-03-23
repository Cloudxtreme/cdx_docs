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
 * Home object for domain model class AudShipmentReceiptR.
 * @see com.cardiodx.db.waban.audit.AudShipmentReceiptR
 * @author Hibernate Tools
 */
public class AudShipmentReceiptRHome {

	private static final Log log = LogFactory
			.getLog(AudShipmentReceiptRHome.class);

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

	public void persist(AudShipmentReceiptR transientInstance) {
		log.debug("persisting AudShipmentReceiptR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudShipmentReceiptR instance) {
		log.debug("attaching dirty AudShipmentReceiptR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudShipmentReceiptR instance) {
		log.debug("attaching clean AudShipmentReceiptR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudShipmentReceiptR persistentInstance) {
		log.debug("deleting AudShipmentReceiptR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudShipmentReceiptR merge(AudShipmentReceiptR detachedInstance) {
		log.debug("merging AudShipmentReceiptR instance");
		try {
			AudShipmentReceiptR result = (AudShipmentReceiptR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudShipmentReceiptR findById(
			com.cardiodx.db.waban.audit.AudShipmentReceiptRId id) {
		log.debug("getting AudShipmentReceiptR instance with id: " + id);
		try {
			AudShipmentReceiptR instance = (AudShipmentReceiptR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudShipmentReceiptR",
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

	public List<AudShipmentReceiptR> findByExample(AudShipmentReceiptR instance) {
		log.debug("finding AudShipmentReceiptR instance by example");
		try {
			List<AudShipmentReceiptR> results = (List<AudShipmentReceiptR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudShipmentReceiptR")
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
