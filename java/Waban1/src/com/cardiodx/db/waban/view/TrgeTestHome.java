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
 * Home object for domain model class TrgeTest.
 * @see com.cardiodx.db.waban.view.TrgeTest
 * @author Hibernate Tools
 */
public class TrgeTestHome {

	private static final Log log = LogFactory.getLog(TrgeTestHome.class);

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

	public void persist(TrgeTest transientInstance) {
		log.debug("persisting TrgeTest instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeTest instance) {
		log.debug("attaching dirty TrgeTest instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeTest instance) {
		log.debug("attaching clean TrgeTest instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeTest persistentInstance) {
		log.debug("deleting TrgeTest instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeTest merge(TrgeTest detachedInstance) {
		log.debug("merging TrgeTest instance");
		try {
			TrgeTest result = (TrgeTest) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeTest findById(com.cardiodx.db.waban.view.TrgeTestId id) {
		log.debug("getting TrgeTest instance with id: " + id);
		try {
			TrgeTest instance = (TrgeTest) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.view.TrgeTest", id);
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

	public List<TrgeTest> findByExample(TrgeTest instance) {
		log.debug("finding TrgeTest instance by example");
		try {
			List<TrgeTest> results = (List<TrgeTest>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeTest")
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
