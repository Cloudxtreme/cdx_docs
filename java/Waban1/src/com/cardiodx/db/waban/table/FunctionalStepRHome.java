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
 * Home object for domain model class FunctionalStepR.
 * @see com.cardiodx.db.waban.table.FunctionalStepR
 * @author Hibernate Tools
 */
public class FunctionalStepRHome {

	private static final Log log = LogFactory.getLog(FunctionalStepRHome.class);

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

	public void persist(FunctionalStepR transientInstance) {
		log.debug("persisting FunctionalStepR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FunctionalStepR instance) {
		log.debug("attaching dirty FunctionalStepR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FunctionalStepR instance) {
		log.debug("attaching clean FunctionalStepR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FunctionalStepR persistentInstance) {
		log.debug("deleting FunctionalStepR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FunctionalStepR merge(FunctionalStepR detachedInstance) {
		log.debug("merging FunctionalStepR instance");
		try {
			FunctionalStepR result = (FunctionalStepR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FunctionalStepR findById(
			com.cardiodx.db.waban.table.FunctionalStepRId id) {
		log.debug("getting FunctionalStepR instance with id: " + id);
		try {
			FunctionalStepR instance = (FunctionalStepR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.FunctionalStepR", id);
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

	public List<FunctionalStepR> findByExample(FunctionalStepR instance) {
		log.debug("finding FunctionalStepR instance by example");
		try {
			List<FunctionalStepR> results = (List<FunctionalStepR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.FunctionalStepR")
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
