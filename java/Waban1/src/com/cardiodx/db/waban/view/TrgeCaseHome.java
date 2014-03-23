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
 * Home object for domain model class TrgeCase.
 * @see com.cardiodx.db.waban.view.TrgeCase
 * @author Hibernate Tools
 */
public class TrgeCaseHome {

	private static final Log log = LogFactory.getLog(TrgeCaseHome.class);

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

	public void persist(TrgeCase transientInstance) {
		log.debug("persisting TrgeCase instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeCase instance) {
		log.debug("attaching dirty TrgeCase instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeCase instance) {
		log.debug("attaching clean TrgeCase instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeCase persistentInstance) {
		log.debug("deleting TrgeCase instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeCase merge(TrgeCase detachedInstance) {
		log.debug("merging TrgeCase instance");
		try {
			TrgeCase result = (TrgeCase) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeCase findById(com.cardiodx.db.waban.view.TrgeCaseId id) {
		log.debug("getting TrgeCase instance with id: " + id);
		try {
			TrgeCase instance = (TrgeCase) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.view.TrgeCase", id);
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

	public List<TrgeCase> findByExample(TrgeCase instance) {
		log.debug("finding TrgeCase instance by example");
		try {
			List<TrgeCase> results = (List<TrgeCase>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeCase")
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
