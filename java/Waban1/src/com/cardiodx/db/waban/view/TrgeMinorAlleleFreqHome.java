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
 * Home object for domain model class TrgeMinorAlleleFreq.
 * @see com.cardiodx.db.waban.view.TrgeMinorAlleleFreq
 * @author Hibernate Tools
 */
public class TrgeMinorAlleleFreqHome {

	private static final Log log = LogFactory
			.getLog(TrgeMinorAlleleFreqHome.class);

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

	public void persist(TrgeMinorAlleleFreq transientInstance) {
		log.debug("persisting TrgeMinorAlleleFreq instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeMinorAlleleFreq instance) {
		log.debug("attaching dirty TrgeMinorAlleleFreq instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeMinorAlleleFreq instance) {
		log.debug("attaching clean TrgeMinorAlleleFreq instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeMinorAlleleFreq persistentInstance) {
		log.debug("deleting TrgeMinorAlleleFreq instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeMinorAlleleFreq merge(TrgeMinorAlleleFreq detachedInstance) {
		log.debug("merging TrgeMinorAlleleFreq instance");
		try {
			TrgeMinorAlleleFreq result = (TrgeMinorAlleleFreq) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeMinorAlleleFreq findById(
			com.cardiodx.db.waban.view.TrgeMinorAlleleFreqId id) {
		log.debug("getting TrgeMinorAlleleFreq instance with id: " + id);
		try {
			TrgeMinorAlleleFreq instance = (TrgeMinorAlleleFreq) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeMinorAlleleFreq",
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

	public List<TrgeMinorAlleleFreq> findByExample(TrgeMinorAlleleFreq instance) {
		log.debug("finding TrgeMinorAlleleFreq instance by example");
		try {
			List<TrgeMinorAlleleFreq> results = (List<TrgeMinorAlleleFreq>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.TrgeMinorAlleleFreq")
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
