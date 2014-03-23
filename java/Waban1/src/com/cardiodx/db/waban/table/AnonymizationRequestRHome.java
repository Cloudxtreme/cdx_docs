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
 * Home object for domain model class AnonymizationRequestR.
 * @see com.cardiodx.db.waban.table.AnonymizationRequestR
 * @author Hibernate Tools
 */
public class AnonymizationRequestRHome {

	private static final Log log = LogFactory
			.getLog(AnonymizationRequestRHome.class);

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

	public void persist(AnonymizationRequestR transientInstance) {
		log.debug("persisting AnonymizationRequestR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizationRequestR instance) {
		log.debug("attaching dirty AnonymizationRequestR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizationRequestR instance) {
		log.debug("attaching clean AnonymizationRequestR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizationRequestR persistentInstance) {
		log.debug("deleting AnonymizationRequestR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizationRequestR merge(AnonymizationRequestR detachedInstance) {
		log.debug("merging AnonymizationRequestR instance");
		try {
			AnonymizationRequestR result = (AnonymizationRequestR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizationRequestR findById(
			com.cardiodx.db.waban.table.AnonymizationRequestRId id) {
		log.debug("getting AnonymizationRequestR instance with id: " + id);
		try {
			AnonymizationRequestR instance = (AnonymizationRequestR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AnonymizationRequestR",
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

	public List<AnonymizationRequestR> findByExample(
			AnonymizationRequestR instance) {
		log.debug("finding AnonymizationRequestR instance by example");
		try {
			List<AnonymizationRequestR> results = (List<AnonymizationRequestR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AnonymizationRequestR")
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
