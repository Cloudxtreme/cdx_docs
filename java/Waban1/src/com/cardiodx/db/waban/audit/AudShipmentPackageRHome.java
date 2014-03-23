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
 * Home object for domain model class AudShipmentPackageR.
 * @see com.cardiodx.db.waban.audit.AudShipmentPackageR
 * @author Hibernate Tools
 */
public class AudShipmentPackageRHome {

	private static final Log log = LogFactory
			.getLog(AudShipmentPackageRHome.class);

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

	public void persist(AudShipmentPackageR transientInstance) {
		log.debug("persisting AudShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudShipmentPackageR instance) {
		log.debug("attaching dirty AudShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudShipmentPackageR instance) {
		log.debug("attaching clean AudShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudShipmentPackageR persistentInstance) {
		log.debug("deleting AudShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudShipmentPackageR merge(AudShipmentPackageR detachedInstance) {
		log.debug("merging AudShipmentPackageR instance");
		try {
			AudShipmentPackageR result = (AudShipmentPackageR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudShipmentPackageR findById(
			com.cardiodx.db.waban.audit.AudShipmentPackageRId id) {
		log.debug("getting AudShipmentPackageR instance with id: " + id);
		try {
			AudShipmentPackageR instance = (AudShipmentPackageR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudShipmentPackageR",
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

	public List<AudShipmentPackageR> findByExample(AudShipmentPackageR instance) {
		log.debug("finding AudShipmentPackageR instance by example");
		try {
			List<AudShipmentPackageR> results = (List<AudShipmentPackageR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudShipmentPackageR")
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
