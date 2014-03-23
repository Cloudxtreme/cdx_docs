package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudOligoDesign.
 * @see com.cardiodx.db.waban.audit.AudOligoDesign
 * @author Hibernate Tools
 */
public class AudOligoDesignHome {

	private static final Log log = LogFactory.getLog(AudOligoDesignHome.class);

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

	public void persist(AudOligoDesign transientInstance) {
		log.debug("persisting AudOligoDesign instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudOligoDesign instance) {
		log.debug("attaching dirty AudOligoDesign instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudOligoDesign instance) {
		log.debug("attaching clean AudOligoDesign instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudOligoDesign persistentInstance) {
		log.debug("deleting AudOligoDesign instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudOligoDesign merge(AudOligoDesign detachedInstance) {
		log.debug("merging AudOligoDesign instance");
		try {
			AudOligoDesign result = (AudOligoDesign) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudOligoDesign findById(java.math.BigDecimal id) {
		log.debug("getting AudOligoDesign instance with id: " + id);
		try {
			AudOligoDesign instance = (AudOligoDesign) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudOligoDesign", id);
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

	public List<AudOligoDesign> findByExample(AudOligoDesign instance) {
		log.debug("finding AudOligoDesign instance by example");
		try {
			List<AudOligoDesign> results = (List<AudOligoDesign>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudOligoDesign")
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
