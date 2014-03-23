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
 * Home object for domain model class AudRoiSelection.
 * @see com.cardiodx.db.waban.audit.AudRoiSelection
 * @author Hibernate Tools
 */
public class AudRoiSelectionHome {

	private static final Log log = LogFactory.getLog(AudRoiSelectionHome.class);

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

	public void persist(AudRoiSelection transientInstance) {
		log.debug("persisting AudRoiSelection instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudRoiSelection instance) {
		log.debug("attaching dirty AudRoiSelection instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudRoiSelection instance) {
		log.debug("attaching clean AudRoiSelection instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudRoiSelection persistentInstance) {
		log.debug("deleting AudRoiSelection instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudRoiSelection merge(AudRoiSelection detachedInstance) {
		log.debug("merging AudRoiSelection instance");
		try {
			AudRoiSelection result = (AudRoiSelection) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudRoiSelection findById(java.math.BigDecimal id) {
		log.debug("getting AudRoiSelection instance with id: " + id);
		try {
			AudRoiSelection instance = (AudRoiSelection) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudRoiSelection", id);
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

	public List<AudRoiSelection> findByExample(AudRoiSelection instance) {
		log.debug("finding AudRoiSelection instance by example");
		try {
			List<AudRoiSelection> results = (List<AudRoiSelection>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudRoiSelection")
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
