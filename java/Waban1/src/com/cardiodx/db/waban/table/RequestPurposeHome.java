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
 * Home object for domain model class RequestPurpose.
 * @see com.cardiodx.db.waban.table.RequestPurpose
 * @author Hibernate Tools
 */
public class RequestPurposeHome {

	private static final Log log = LogFactory.getLog(RequestPurposeHome.class);

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

	public void persist(RequestPurpose transientInstance) {
		log.debug("persisting RequestPurpose instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RequestPurpose instance) {
		log.debug("attaching dirty RequestPurpose instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RequestPurpose instance) {
		log.debug("attaching clean RequestPurpose instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RequestPurpose persistentInstance) {
		log.debug("deleting RequestPurpose instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RequestPurpose merge(RequestPurpose detachedInstance) {
		log.debug("merging RequestPurpose instance");
		try {
			RequestPurpose result = (RequestPurpose) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RequestPurpose findById(java.math.BigDecimal id) {
		log.debug("getting RequestPurpose instance with id: " + id);
		try {
			RequestPurpose instance = (RequestPurpose) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.RequestPurpose", id);
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

	public List<RequestPurpose> findByExample(RequestPurpose instance) {
		log.debug("finding RequestPurpose instance by example");
		try {
			List<RequestPurpose> results = (List<RequestPurpose>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.RequestPurpose")
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
