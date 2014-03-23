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
 * Home object for domain model class PlateWellType.
 * @see com.cardiodx.db.waban.table.PlateWellType
 * @author Hibernate Tools
 */
public class PlateWellTypeHome {

	private static final Log log = LogFactory.getLog(PlateWellTypeHome.class);

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

	public void persist(PlateWellType transientInstance) {
		log.debug("persisting PlateWellType instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateWellType instance) {
		log.debug("attaching dirty PlateWellType instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateWellType instance) {
		log.debug("attaching clean PlateWellType instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateWellType persistentInstance) {
		log.debug("deleting PlateWellType instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateWellType merge(PlateWellType detachedInstance) {
		log.debug("merging PlateWellType instance");
		try {
			PlateWellType result = (PlateWellType) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateWellType findById(java.math.BigDecimal id) {
		log.debug("getting PlateWellType instance with id: " + id);
		try {
			PlateWellType instance = (PlateWellType) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PlateWellType", id);
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

	public List<PlateWellType> findByExample(PlateWellType instance) {
		log.debug("finding PlateWellType instance by example");
		try {
			List<PlateWellType> results = (List<PlateWellType>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.PlateWellType")
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
