package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DnaDesRequest.
 * @see com.cardiodx.db.waban.view.DnaDesRequest
 * @author Hibernate Tools
 */
public class DnaDesRequestHome {

	private static final Log log = LogFactory.getLog(DnaDesRequestHome.class);

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

	public void persist(DnaDesRequest transientInstance) {
		log.debug("persisting DnaDesRequest instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaDesRequest instance) {
		log.debug("attaching dirty DnaDesRequest instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaDesRequest instance) {
		log.debug("attaching clean DnaDesRequest instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaDesRequest persistentInstance) {
		log.debug("deleting DnaDesRequest instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaDesRequest merge(DnaDesRequest detachedInstance) {
		log.debug("merging DnaDesRequest instance");
		try {
			DnaDesRequest result = (DnaDesRequest) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaDesRequest findById(com.cardiodx.db.waban.view.DnaDesRequestId id) {
		log.debug("getting DnaDesRequest instance with id: " + id);
		try {
			DnaDesRequest instance = (DnaDesRequest) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.DnaDesRequest", id);
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

	public List<DnaDesRequest> findByExample(DnaDesRequest instance) {
		log.debug("finding DnaDesRequest instance by example");
		try {
			List<DnaDesRequest> results = (List<DnaDesRequest>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.DnaDesRequest")
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
