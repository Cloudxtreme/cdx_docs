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
 * Home object for domain model class SpecimenShipmentR.
 * @see com.cardiodx.db.waban.table.SpecimenShipmentR
 * @author Hibernate Tools
 */
public class SpecimenShipmentRHome {

	private static final Log log = LogFactory
			.getLog(SpecimenShipmentRHome.class);

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

	public void persist(SpecimenShipmentR transientInstance) {
		log.debug("persisting SpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenShipmentR instance) {
		log.debug("attaching dirty SpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenShipmentR instance) {
		log.debug("attaching clean SpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenShipmentR persistentInstance) {
		log.debug("deleting SpecimenShipmentR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenShipmentR merge(SpecimenShipmentR detachedInstance) {
		log.debug("merging SpecimenShipmentR instance");
		try {
			SpecimenShipmentR result = (SpecimenShipmentR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenShipmentR findById(
			com.cardiodx.db.waban.table.SpecimenShipmentRId id) {
		log.debug("getting SpecimenShipmentR instance with id: " + id);
		try {
			SpecimenShipmentR instance = (SpecimenShipmentR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SpecimenShipmentR", id);
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

	public List<SpecimenShipmentR> findByExample(SpecimenShipmentR instance) {
		log.debug("finding SpecimenShipmentR instance by example");
		try {
			List<SpecimenShipmentR> results = (List<SpecimenShipmentR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SpecimenShipmentR")
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
