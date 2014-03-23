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
 * Home object for domain model class AnonymizationStudySetup.
 * @see com.cardiodx.db.waban.table.AnonymizationStudySetup
 * @author Hibernate Tools
 */
public class AnonymizationStudySetupHome {

	private static final Log log = LogFactory
			.getLog(AnonymizationStudySetupHome.class);

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

	public void persist(AnonymizationStudySetup transientInstance) {
		log.debug("persisting AnonymizationStudySetup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizationStudySetup instance) {
		log.debug("attaching dirty AnonymizationStudySetup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizationStudySetup instance) {
		log.debug("attaching clean AnonymizationStudySetup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizationStudySetup persistentInstance) {
		log.debug("deleting AnonymizationStudySetup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizationStudySetup merge(
			AnonymizationStudySetup detachedInstance) {
		log.debug("merging AnonymizationStudySetup instance");
		try {
			AnonymizationStudySetup result = (AnonymizationStudySetup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizationStudySetup findById(java.math.BigDecimal id) {
		log.debug("getting AnonymizationStudySetup instance with id: " + id);
		try {
			AnonymizationStudySetup instance = (AnonymizationStudySetup) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AnonymizationStudySetup",
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

	public List<AnonymizationStudySetup> findByExample(
			AnonymizationStudySetup instance) {
		log.debug("finding AnonymizationStudySetup instance by example");
		try {
			List<AnonymizationStudySetup> results = (List<AnonymizationStudySetup>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AnonymizationStudySetup")
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
