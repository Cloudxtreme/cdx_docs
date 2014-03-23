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
 * Home object for domain model class OligoAssayDesign.
 * @see com.cardiodx.db.waban.table.OligoAssayDesign
 * @author Hibernate Tools
 */
public class OligoAssayDesignHome {

	private static final Log log = LogFactory
			.getLog(OligoAssayDesignHome.class);

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

	public void persist(OligoAssayDesign transientInstance) {
		log.debug("persisting OligoAssayDesign instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoAssayDesign instance) {
		log.debug("attaching dirty OligoAssayDesign instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoAssayDesign instance) {
		log.debug("attaching clean OligoAssayDesign instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoAssayDesign persistentInstance) {
		log.debug("deleting OligoAssayDesign instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoAssayDesign merge(OligoAssayDesign detachedInstance) {
		log.debug("merging OligoAssayDesign instance");
		try {
			OligoAssayDesign result = (OligoAssayDesign) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoAssayDesign findById(java.math.BigDecimal id) {
		log.debug("getting OligoAssayDesign instance with id: " + id);
		try {
			OligoAssayDesign instance = (OligoAssayDesign) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OligoAssayDesign", id);
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

	public List<OligoAssayDesign> findByExample(OligoAssayDesign instance) {
		log.debug("finding OligoAssayDesign instance by example");
		try {
			List<OligoAssayDesign> results = (List<OligoAssayDesign>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.OligoAssayDesign")
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
