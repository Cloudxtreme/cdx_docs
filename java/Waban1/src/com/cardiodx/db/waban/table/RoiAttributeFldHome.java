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
 * Home object for domain model class RoiAttributeFld.
 * @see com.cardiodx.db.waban.table.RoiAttributeFld
 * @author Hibernate Tools
 */
public class RoiAttributeFldHome {

	private static final Log log = LogFactory.getLog(RoiAttributeFldHome.class);

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

	public void persist(RoiAttributeFld transientInstance) {
		log.debug("persisting RoiAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RoiAttributeFld instance) {
		log.debug("attaching dirty RoiAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoiAttributeFld instance) {
		log.debug("attaching clean RoiAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RoiAttributeFld persistentInstance) {
		log.debug("deleting RoiAttributeFld instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoiAttributeFld merge(RoiAttributeFld detachedInstance) {
		log.debug("merging RoiAttributeFld instance");
		try {
			RoiAttributeFld result = (RoiAttributeFld) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoiAttributeFld findById(java.math.BigDecimal id) {
		log.debug("getting RoiAttributeFld instance with id: " + id);
		try {
			RoiAttributeFld instance = (RoiAttributeFld) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.RoiAttributeFld", id);
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

	public List<RoiAttributeFld> findByExample(RoiAttributeFld instance) {
		log.debug("finding RoiAttributeFld instance by example");
		try {
			List<RoiAttributeFld> results = (List<RoiAttributeFld>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.RoiAttributeFld")
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
