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
 * Home object for domain model class TrgeCaseSample.
 * @see com.cardiodx.db.waban.view.TrgeCaseSample
 * @author Hibernate Tools
 */
public class TrgeCaseSampleHome {

	private static final Log log = LogFactory.getLog(TrgeCaseSampleHome.class);

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

	public void persist(TrgeCaseSample transientInstance) {
		log.debug("persisting TrgeCaseSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeCaseSample instance) {
		log.debug("attaching dirty TrgeCaseSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeCaseSample instance) {
		log.debug("attaching clean TrgeCaseSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeCaseSample persistentInstance) {
		log.debug("deleting TrgeCaseSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeCaseSample merge(TrgeCaseSample detachedInstance) {
		log.debug("merging TrgeCaseSample instance");
		try {
			TrgeCaseSample result = (TrgeCaseSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeCaseSample findById(
			com.cardiodx.db.waban.view.TrgeCaseSampleId id) {
		log.debug("getting TrgeCaseSample instance with id: " + id);
		try {
			TrgeCaseSample instance = (TrgeCaseSample) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeCaseSample", id);
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

	public List<TrgeCaseSample> findByExample(TrgeCaseSample instance) {
		log.debug("finding TrgeCaseSample instance by example");
		try {
			List<TrgeCaseSample> results = (List<TrgeCaseSample>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeCaseSample")
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
