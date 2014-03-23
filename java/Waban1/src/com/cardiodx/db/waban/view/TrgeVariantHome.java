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
 * Home object for domain model class TrgeVariant.
 * @see com.cardiodx.db.waban.view.TrgeVariant
 * @author Hibernate Tools
 */
public class TrgeVariantHome {

	private static final Log log = LogFactory.getLog(TrgeVariantHome.class);

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

	public void persist(TrgeVariant transientInstance) {
		log.debug("persisting TrgeVariant instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeVariant instance) {
		log.debug("attaching dirty TrgeVariant instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeVariant instance) {
		log.debug("attaching clean TrgeVariant instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeVariant persistentInstance) {
		log.debug("deleting TrgeVariant instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeVariant merge(TrgeVariant detachedInstance) {
		log.debug("merging TrgeVariant instance");
		try {
			TrgeVariant result = (TrgeVariant) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeVariant findById(com.cardiodx.db.waban.view.TrgeVariantId id) {
		log.debug("getting TrgeVariant instance with id: " + id);
		try {
			TrgeVariant instance = (TrgeVariant) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeVariant", id);
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

	public List<TrgeVariant> findByExample(TrgeVariant instance) {
		log.debug("finding TrgeVariant instance by example");
		try {
			List<TrgeVariant> results = (List<TrgeVariant>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeVariant")
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
