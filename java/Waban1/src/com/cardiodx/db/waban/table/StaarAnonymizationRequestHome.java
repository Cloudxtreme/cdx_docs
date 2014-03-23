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
 * Home object for domain model class StaarAnonymizationRequest.
 * @see com.cardiodx.db.waban.table.StaarAnonymizationRequest
 * @author Hibernate Tools
 */
public class StaarAnonymizationRequestHome {

	private static final Log log = LogFactory
			.getLog(StaarAnonymizationRequestHome.class);

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

	public void persist(StaarAnonymizationRequest transientInstance) {
		log.debug("persisting StaarAnonymizationRequest instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StaarAnonymizationRequest instance) {
		log.debug("attaching dirty StaarAnonymizationRequest instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StaarAnonymizationRequest instance) {
		log.debug("attaching clean StaarAnonymizationRequest instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StaarAnonymizationRequest persistentInstance) {
		log.debug("deleting StaarAnonymizationRequest instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StaarAnonymizationRequest merge(
			StaarAnonymizationRequest detachedInstance) {
		log.debug("merging StaarAnonymizationRequest instance");
		try {
			StaarAnonymizationRequest result = (StaarAnonymizationRequest) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StaarAnonymizationRequest findById(java.math.BigDecimal id) {
		log.debug("getting StaarAnonymizationRequest instance with id: " + id);
		try {
			StaarAnonymizationRequest instance = (StaarAnonymizationRequest) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.StaarAnonymizationRequest",
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

	public List<StaarAnonymizationRequest> findByExample(
			StaarAnonymizationRequest instance) {
		log.debug("finding StaarAnonymizationRequest instance by example");
		try {
			List<StaarAnonymizationRequest> results = (List<StaarAnonymizationRequest>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.StaarAnonymizationRequest")
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
