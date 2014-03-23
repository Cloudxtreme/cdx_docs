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
 * Home object for domain model class AudCaseRoiR.
 * @see com.cardiodx.db.waban.audit.AudCaseRoiR
 * @author Hibernate Tools
 */
public class AudCaseRoiRHome {

	private static final Log log = LogFactory.getLog(AudCaseRoiRHome.class);

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

	public void persist(AudCaseRoiR transientInstance) {
		log.debug("persisting AudCaseRoiR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudCaseRoiR instance) {
		log.debug("attaching dirty AudCaseRoiR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudCaseRoiR instance) {
		log.debug("attaching clean AudCaseRoiR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudCaseRoiR persistentInstance) {
		log.debug("deleting AudCaseRoiR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudCaseRoiR merge(AudCaseRoiR detachedInstance) {
		log.debug("merging AudCaseRoiR instance");
		try {
			AudCaseRoiR result = (AudCaseRoiR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudCaseRoiR findById(com.cardiodx.db.waban.audit.AudCaseRoiRId id) {
		log.debug("getting AudCaseRoiR instance with id: " + id);
		try {
			AudCaseRoiR instance = (AudCaseRoiR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudCaseRoiR", id);
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

	public List<AudCaseRoiR> findByExample(AudCaseRoiR instance) {
		log.debug("finding AudCaseRoiR instance by example");
		try {
			List<AudCaseRoiR> results = (List<AudCaseRoiR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudCaseRoiR")
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
