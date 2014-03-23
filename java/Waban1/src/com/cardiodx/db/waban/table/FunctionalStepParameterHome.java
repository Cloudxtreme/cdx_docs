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
 * Home object for domain model class FunctionalStepParameter.
 * @see com.cardiodx.db.waban.table.FunctionalStepParameter
 * @author Hibernate Tools
 */
public class FunctionalStepParameterHome {

	private static final Log log = LogFactory
			.getLog(FunctionalStepParameterHome.class);

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

	public void persist(FunctionalStepParameter transientInstance) {
		log.debug("persisting FunctionalStepParameter instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FunctionalStepParameter instance) {
		log.debug("attaching dirty FunctionalStepParameter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FunctionalStepParameter instance) {
		log.debug("attaching clean FunctionalStepParameter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FunctionalStepParameter persistentInstance) {
		log.debug("deleting FunctionalStepParameter instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FunctionalStepParameter merge(
			FunctionalStepParameter detachedInstance) {
		log.debug("merging FunctionalStepParameter instance");
		try {
			FunctionalStepParameter result = (FunctionalStepParameter) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FunctionalStepParameter findById(java.math.BigDecimal id) {
		log.debug("getting FunctionalStepParameter instance with id: " + id);
		try {
			FunctionalStepParameter instance = (FunctionalStepParameter) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.FunctionalStepParameter",
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

	public List<FunctionalStepParameter> findByExample(
			FunctionalStepParameter instance) {
		log.debug("finding FunctionalStepParameter instance by example");
		try {
			List<FunctionalStepParameter> results = (List<FunctionalStepParameter>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.FunctionalStepParameter")
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
