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
 * Home object for domain model class PendingSampleAttributeVw.
 * @see com.cardiodx.db.waban.view.PendingSampleAttributeVw
 * @author Hibernate Tools
 */
public class PendingSampleAttributeVwHome {

	private static final Log log = LogFactory
			.getLog(PendingSampleAttributeVwHome.class);

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

	public void persist(PendingSampleAttributeVw transientInstance) {
		log.debug("persisting PendingSampleAttributeVw instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingSampleAttributeVw instance) {
		log.debug("attaching dirty PendingSampleAttributeVw instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingSampleAttributeVw instance) {
		log.debug("attaching clean PendingSampleAttributeVw instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingSampleAttributeVw persistentInstance) {
		log.debug("deleting PendingSampleAttributeVw instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingSampleAttributeVw merge(
			PendingSampleAttributeVw detachedInstance) {
		log.debug("merging PendingSampleAttributeVw instance");
		try {
			PendingSampleAttributeVw result = (PendingSampleAttributeVw) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingSampleAttributeVw findById(
			com.cardiodx.db.waban.view.PendingSampleAttributeVwId id) {
		log.debug("getting PendingSampleAttributeVw instance with id: " + id);
		try {
			PendingSampleAttributeVw instance = (PendingSampleAttributeVw) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.PendingSampleAttributeVw",
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

	public List<PendingSampleAttributeVw> findByExample(
			PendingSampleAttributeVw instance) {
		log.debug("finding PendingSampleAttributeVw instance by example");
		try {
			List<PendingSampleAttributeVw> results = (List<PendingSampleAttributeVw>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PendingSampleAttributeVw")
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
