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
 * Home object for domain model class AnonymizationStudySetupR.
 * @see com.cardiodx.db.waban.table.AnonymizationStudySetupR
 * @author Hibernate Tools
 */
public class AnonymizationStudySetupRHome {

	private static final Log log = LogFactory
			.getLog(AnonymizationStudySetupRHome.class);

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

	public void persist(AnonymizationStudySetupR transientInstance) {
		log.debug("persisting AnonymizationStudySetupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizationStudySetupR instance) {
		log.debug("attaching dirty AnonymizationStudySetupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizationStudySetupR instance) {
		log.debug("attaching clean AnonymizationStudySetupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizationStudySetupR persistentInstance) {
		log.debug("deleting AnonymizationStudySetupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizationStudySetupR merge(
			AnonymizationStudySetupR detachedInstance) {
		log.debug("merging AnonymizationStudySetupR instance");
		try {
			AnonymizationStudySetupR result = (AnonymizationStudySetupR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizationStudySetupR findById(
			com.cardiodx.db.waban.table.AnonymizationStudySetupRId id) {
		log.debug("getting AnonymizationStudySetupR instance with id: " + id);
		try {
			AnonymizationStudySetupR instance = (AnonymizationStudySetupR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AnonymizationStudySetupR",
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

	public List<AnonymizationStudySetupR> findByExample(
			AnonymizationStudySetupR instance) {
		log.debug("finding AnonymizationStudySetupR instance by example");
		try {
			List<AnonymizationStudySetupR> results = (List<AnonymizationStudySetupR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AnonymizationStudySetupR")
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
