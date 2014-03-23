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
 * Home object for domain model class FunctionalStep.
 * @see com.cardiodx.db.waban.table.FunctionalStep
 * @author Hibernate Tools
 */
public class FunctionalStepHome {

	private static final Log log = LogFactory.getLog(FunctionalStepHome.class);

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

	public void persist(FunctionalStep transientInstance) {
		log.debug("persisting FunctionalStep instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FunctionalStep instance) {
		log.debug("attaching dirty FunctionalStep instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FunctionalStep instance) {
		log.debug("attaching clean FunctionalStep instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FunctionalStep persistentInstance) {
		log.debug("deleting FunctionalStep instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FunctionalStep merge(FunctionalStep detachedInstance) {
		log.debug("merging FunctionalStep instance");
		try {
			FunctionalStep result = (FunctionalStep) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FunctionalStep findById(java.math.BigDecimal id) {
		log.debug("getting FunctionalStep instance with id: " + id);
		try {
			FunctionalStep instance = (FunctionalStep) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.FunctionalStep", id);
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

	public List<FunctionalStep> findByExample(FunctionalStep instance) {
		log.debug("finding FunctionalStep instance by example");
		try {
			List<FunctionalStep> results = (List<FunctionalStep>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.FunctionalStep")
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
