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
 * Home object for domain model class AudSpecimenShipmentAirR.
 * @see com.cardiodx.db.waban.audit.AudSpecimenShipmentAirR
 * @author Hibernate Tools
 */
public class AudSpecimenShipmentAirRHome {

	private static final Log log = LogFactory
			.getLog(AudSpecimenShipmentAirRHome.class);

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

	public void persist(AudSpecimenShipmentAirR transientInstance) {
		log.debug("persisting AudSpecimenShipmentAirR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSpecimenShipmentAirR instance) {
		log.debug("attaching dirty AudSpecimenShipmentAirR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSpecimenShipmentAirR instance) {
		log.debug("attaching clean AudSpecimenShipmentAirR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSpecimenShipmentAirR persistentInstance) {
		log.debug("deleting AudSpecimenShipmentAirR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSpecimenShipmentAirR merge(
			AudSpecimenShipmentAirR detachedInstance) {
		log.debug("merging AudSpecimenShipmentAirR instance");
		try {
			AudSpecimenShipmentAirR result = (AudSpecimenShipmentAirR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSpecimenShipmentAirR findById(
			com.cardiodx.db.waban.audit.AudSpecimenShipmentAirRId id) {
		log.debug("getting AudSpecimenShipmentAirR instance with id: " + id);
		try {
			AudSpecimenShipmentAirR instance = (AudSpecimenShipmentAirR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudSpecimenShipmentAirR",
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

	public List<AudSpecimenShipmentAirR> findByExample(
			AudSpecimenShipmentAirR instance) {
		log.debug("finding AudSpecimenShipmentAirR instance by example");
		try {
			List<AudSpecimenShipmentAirR> results = (List<AudSpecimenShipmentAirR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudSpecimenShipmentAirR")
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
