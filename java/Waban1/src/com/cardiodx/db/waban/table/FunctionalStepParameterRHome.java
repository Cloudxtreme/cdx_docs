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
 * Home object for domain model class FunctionalStepParameterR.
 * @see com.cardiodx.db.waban.table.FunctionalStepParameterR
 * @author Hibernate Tools
 */
public class FunctionalStepParameterRHome {

	private static final Log log = LogFactory
			.getLog(FunctionalStepParameterRHome.class);

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

	public void persist(FunctionalStepParameterR transientInstance) {
		log.debug("persisting FunctionalStepParameterR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FunctionalStepParameterR instance) {
		log.debug("attaching dirty FunctionalStepParameterR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FunctionalStepParameterR instance) {
		log.debug("attaching clean FunctionalStepParameterR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FunctionalStepParameterR persistentInstance) {
		log.debug("deleting FunctionalStepParameterR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FunctionalStepParameterR merge(
			FunctionalStepParameterR detachedInstance) {
		log.debug("merging FunctionalStepParameterR instance");
		try {
			FunctionalStepParameterR result = (FunctionalStepParameterR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FunctionalStepParameterR findById(
			com.cardiodx.db.waban.table.FunctionalStepParameterRId id) {
		log.debug("getting FunctionalStepParameterR instance with id: " + id);
		try {
			FunctionalStepParameterR instance = (FunctionalStepParameterR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.FunctionalStepParameterR",
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

	public List<FunctionalStepParameterR> findByExample(
			FunctionalStepParameterR instance) {
		log.debug("finding FunctionalStepParameterR instance by example");
		try {
			List<FunctionalStepParameterR> results = (List<FunctionalStepParameterR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.FunctionalStepParameterR")
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
