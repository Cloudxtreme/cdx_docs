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
 * Home object for domain model class PlateWellTypeR.
 * @see com.cardiodx.db.waban.table.PlateWellTypeR
 * @author Hibernate Tools
 */
public class PlateWellTypeRHome {

	private static final Log log = LogFactory.getLog(PlateWellTypeRHome.class);

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

	public void persist(PlateWellTypeR transientInstance) {
		log.debug("persisting PlateWellTypeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateWellTypeR instance) {
		log.debug("attaching dirty PlateWellTypeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateWellTypeR instance) {
		log.debug("attaching clean PlateWellTypeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateWellTypeR persistentInstance) {
		log.debug("deleting PlateWellTypeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateWellTypeR merge(PlateWellTypeR detachedInstance) {
		log.debug("merging PlateWellTypeR instance");
		try {
			PlateWellTypeR result = (PlateWellTypeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateWellTypeR findById(
			com.cardiodx.db.waban.table.PlateWellTypeRId id) {
		log.debug("getting PlateWellTypeR instance with id: " + id);
		try {
			PlateWellTypeR instance = (PlateWellTypeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PlateWellTypeR", id);
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

	public List<PlateWellTypeR> findByExample(PlateWellTypeR instance) {
		log.debug("finding PlateWellTypeR instance by example");
		try {
			List<PlateWellTypeR> results = (List<PlateWellTypeR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PlateWellTypeR")
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
