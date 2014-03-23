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
 * Home object for domain model class AudSpecimenRequestR.
 * @see com.cardiodx.db.waban.audit.AudSpecimenRequestR
 * @author Hibernate Tools
 */
public class AudSpecimenRequestRHome {

	private static final Log log = LogFactory
			.getLog(AudSpecimenRequestRHome.class);

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

	public void persist(AudSpecimenRequestR transientInstance) {
		log.debug("persisting AudSpecimenRequestR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSpecimenRequestR instance) {
		log.debug("attaching dirty AudSpecimenRequestR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSpecimenRequestR instance) {
		log.debug("attaching clean AudSpecimenRequestR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSpecimenRequestR persistentInstance) {
		log.debug("deleting AudSpecimenRequestR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSpecimenRequestR merge(AudSpecimenRequestR detachedInstance) {
		log.debug("merging AudSpecimenRequestR instance");
		try {
			AudSpecimenRequestR result = (AudSpecimenRequestR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSpecimenRequestR findById(
			com.cardiodx.db.waban.audit.AudSpecimenRequestRId id) {
		log.debug("getting AudSpecimenRequestR instance with id: " + id);
		try {
			AudSpecimenRequestR instance = (AudSpecimenRequestR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudSpecimenRequestR",
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

	public List<AudSpecimenRequestR> findByExample(AudSpecimenRequestR instance) {
		log.debug("finding AudSpecimenRequestR instance by example");
		try {
			List<AudSpecimenRequestR> results = (List<AudSpecimenRequestR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudSpecimenRequestR")
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
