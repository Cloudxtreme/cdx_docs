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
 * Home object for domain model class AudSpecimenShipmentPacR.
 * @see com.cardiodx.db.waban.audit.AudSpecimenShipmentPacR
 * @author Hibernate Tools
 */
public class AudSpecimenShipmentPacRHome {

	private static final Log log = LogFactory
			.getLog(AudSpecimenShipmentPacRHome.class);

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

	public void persist(AudSpecimenShipmentPacR transientInstance) {
		log.debug("persisting AudSpecimenShipmentPacR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSpecimenShipmentPacR instance) {
		log.debug("attaching dirty AudSpecimenShipmentPacR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSpecimenShipmentPacR instance) {
		log.debug("attaching clean AudSpecimenShipmentPacR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSpecimenShipmentPacR persistentInstance) {
		log.debug("deleting AudSpecimenShipmentPacR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSpecimenShipmentPacR merge(
			AudSpecimenShipmentPacR detachedInstance) {
		log.debug("merging AudSpecimenShipmentPacR instance");
		try {
			AudSpecimenShipmentPacR result = (AudSpecimenShipmentPacR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSpecimenShipmentPacR findById(
			com.cardiodx.db.waban.audit.AudSpecimenShipmentPacRId id) {
		log.debug("getting AudSpecimenShipmentPacR instance with id: " + id);
		try {
			AudSpecimenShipmentPacR instance = (AudSpecimenShipmentPacR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudSpecimenShipmentPacR",
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

	public List<AudSpecimenShipmentPacR> findByExample(
			AudSpecimenShipmentPacR instance) {
		log.debug("finding AudSpecimenShipmentPacR instance by example");
		try {
			List<AudSpecimenShipmentPacR> results = (List<AudSpecimenShipmentPacR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudSpecimenShipmentPacR")
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
