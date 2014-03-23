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
 * Home object for domain model class AudSpecimenShipmentR.
 * @see com.cardiodx.db.waban.audit.AudSpecimenShipmentR
 * @author Hibernate Tools
 */
public class AudSpecimenShipmentRHome {

	private static final Log log = LogFactory
			.getLog(AudSpecimenShipmentRHome.class);

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

	public void persist(AudSpecimenShipmentR transientInstance) {
		log.debug("persisting AudSpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSpecimenShipmentR instance) {
		log.debug("attaching dirty AudSpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSpecimenShipmentR instance) {
		log.debug("attaching clean AudSpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSpecimenShipmentR persistentInstance) {
		log.debug("deleting AudSpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSpecimenShipmentR merge(AudSpecimenShipmentR detachedInstance) {
		log.debug("merging AudSpecimenShipmentR instance");
		try {
			AudSpecimenShipmentR result = (AudSpecimenShipmentR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSpecimenShipmentR findById(
			com.cardiodx.db.waban.audit.AudSpecimenShipmentRId id) {
		log.debug("getting AudSpecimenShipmentR instance with id: " + id);
		try {
			AudSpecimenShipmentR instance = (AudSpecimenShipmentR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudSpecimenShipmentR",
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

	public List<AudSpecimenShipmentR> findByExample(
			AudSpecimenShipmentR instance) {
		log.debug("finding AudSpecimenShipmentR instance by example");
		try {
			List<AudSpecimenShipmentR> results = (List<AudSpecimenShipmentR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudSpecimenShipmentR")
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
