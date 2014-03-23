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
 * Home object for domain model class MeasurementR.
 * @see com.cardiodx.db.waban.table.MeasurementR
 * @author Hibernate Tools
 */
public class MeasurementRHome {

	private static final Log log = LogFactory.getLog(MeasurementRHome.class);

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

	public void persist(MeasurementR transientInstance) {
		log.debug("persisting MeasurementR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MeasurementR instance) {
		log.debug("attaching dirty MeasurementR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MeasurementR instance) {
		log.debug("attaching clean MeasurementR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MeasurementR persistentInstance) {
		log.debug("deleting MeasurementR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MeasurementR merge(MeasurementR detachedInstance) {
		log.debug("merging MeasurementR instance");
		try {
			MeasurementR result = (MeasurementR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MeasurementR findById(com.cardiodx.db.waban.table.MeasurementRId id) {
		log.debug("getting MeasurementR instance with id: " + id);
		try {
			MeasurementR instance = (MeasurementR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MeasurementR", id);
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

	public List<MeasurementR> findByExample(MeasurementR instance) {
		log.debug("finding MeasurementR instance by example");
		try {
			List<MeasurementR> results = (List<MeasurementR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MeasurementR")
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
