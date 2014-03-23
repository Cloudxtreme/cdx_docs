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
 * Home object for domain model class PcrSetupPlaceRoi.
 * @see com.cardiodx.db.waban.table.PcrSetupPlaceRoi
 * @author Hibernate Tools
 */
public class PcrSetupPlaceRoiHome {

	private static final Log log = LogFactory
			.getLog(PcrSetupPlaceRoiHome.class);

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

	public void persist(PcrSetupPlaceRoi transientInstance) {
		log.debug("persisting PcrSetupPlaceRoi instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrSetupPlaceRoi instance) {
		log.debug("attaching dirty PcrSetupPlaceRoi instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrSetupPlaceRoi instance) {
		log.debug("attaching clean PcrSetupPlaceRoi instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrSetupPlaceRoi persistentInstance) {
		log.debug("deleting PcrSetupPlaceRoi instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrSetupPlaceRoi merge(PcrSetupPlaceRoi detachedInstance) {
		log.debug("merging PcrSetupPlaceRoi instance");
		try {
			PcrSetupPlaceRoi result = (PcrSetupPlaceRoi) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrSetupPlaceRoi findById(java.math.BigDecimal id) {
		log.debug("getting PcrSetupPlaceRoi instance with id: " + id);
		try {
			PcrSetupPlaceRoi instance = (PcrSetupPlaceRoi) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PcrSetupPlaceRoi", id);
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

	public List<PcrSetupPlaceRoi> findByExample(PcrSetupPlaceRoi instance) {
		log.debug("finding PcrSetupPlaceRoi instance by example");
		try {
			List<PcrSetupPlaceRoi> results = (List<PcrSetupPlaceRoi>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PcrSetupPlaceRoi")
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