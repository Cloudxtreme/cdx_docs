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
 * Home object for domain model class OligoPurposeDesign.
 * @see com.cardiodx.db.waban.table.OligoPurposeDesign
 * @author Hibernate Tools
 */
public class OligoPurposeDesignHome {

	private static final Log log = LogFactory
			.getLog(OligoPurposeDesignHome.class);

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

	public void persist(OligoPurposeDesign transientInstance) {
		log.debug("persisting OligoPurposeDesign instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoPurposeDesign instance) {
		log.debug("attaching dirty OligoPurposeDesign instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoPurposeDesign instance) {
		log.debug("attaching clean OligoPurposeDesign instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoPurposeDesign persistentInstance) {
		log.debug("deleting OligoPurposeDesign instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoPurposeDesign merge(OligoPurposeDesign detachedInstance) {
		log.debug("merging OligoPurposeDesign instance");
		try {
			OligoPurposeDesign result = (OligoPurposeDesign) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoPurposeDesign findById(java.math.BigDecimal id) {
		log.debug("getting OligoPurposeDesign instance with id: " + id);
		try {
			OligoPurposeDesign instance = (OligoPurposeDesign) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OligoPurposeDesign",
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

	public List<OligoPurposeDesign> findByExample(OligoPurposeDesign instance) {
		log.debug("finding OligoPurposeDesign instance by example");
		try {
			List<OligoPurposeDesign> results = (List<OligoPurposeDesign>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.OligoPurposeDesign")
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
