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
 * Home object for domain model class ShipmentAirbillR.
 * @see com.cardiodx.db.waban.table.ShipmentAirbillR
 * @author Hibernate Tools
 */
public class ShipmentAirbillRHome {

	private static final Log log = LogFactory
			.getLog(ShipmentAirbillRHome.class);

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

	public void persist(ShipmentAirbillR transientInstance) {
		log.debug("persisting ShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShipmentAirbillR instance) {
		log.debug("attaching dirty ShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShipmentAirbillR instance) {
		log.debug("attaching clean ShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShipmentAirbillR persistentInstance) {
		log.debug("deleting ShipmentAirbillR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShipmentAirbillR merge(ShipmentAirbillR detachedInstance) {
		log.debug("merging ShipmentAirbillR instance");
		try {
			ShipmentAirbillR result = (ShipmentAirbillR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShipmentAirbillR findById(
			com.cardiodx.db.waban.table.ShipmentAirbillRId id) {
		log.debug("getting ShipmentAirbillR instance with id: " + id);
		try {
			ShipmentAirbillR instance = (ShipmentAirbillR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ShipmentAirbillR", id);
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

	public List<ShipmentAirbillR> findByExample(ShipmentAirbillR instance) {
		log.debug("finding ShipmentAirbillR instance by example");
		try {
			List<ShipmentAirbillR> results = (List<ShipmentAirbillR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ShipmentAirbillR")
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
