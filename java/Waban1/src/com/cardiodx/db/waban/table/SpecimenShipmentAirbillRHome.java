package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SpecimenShipmentAirbillR.
 * @see com.cardiodx.db.waban.table.SpecimenShipmentAirbillR
 * @author Hibernate Tools
 */
public class SpecimenShipmentAirbillRHome {

	private static final Log log = LogFactory
			.getLog(SpecimenShipmentAirbillRHome.class);

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

	public void persist(SpecimenShipmentAirbillR transientInstance) {
		log.debug("persisting SpecimenShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenShipmentAirbillR instance) {
		log.debug("attaching dirty SpecimenShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenShipmentAirbillR instance) {
		log.debug("attaching clean SpecimenShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenShipmentAirbillR persistentInstance) {
		log.debug("deleting SpecimenShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenShipmentAirbillR merge(
			SpecimenShipmentAirbillR detachedInstance) {
		log.debug("merging SpecimenShipmentAirbillR instance");
		try {
			SpecimenShipmentAirbillR result = (SpecimenShipmentAirbillR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenShipmentAirbillR findById(
			com.cardiodx.db.waban.table.SpecimenShipmentAirbillRId id) {
		log.debug("getting SpecimenShipmentAirbillR instance with id: " + id);
		try {
			SpecimenShipmentAirbillR instance = (SpecimenShipmentAirbillR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SpecimenShipmentAirbillR",
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

	public List<SpecimenShipmentAirbillR> findByExample(
			SpecimenShipmentAirbillR instance) {
		log.debug("finding SpecimenShipmentAirbillR instance by example");
		try {
			List<SpecimenShipmentAirbillR> results = (List<SpecimenShipmentAirbillR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SpecimenShipmentAirbillR")
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
