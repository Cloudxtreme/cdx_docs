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
 * Home object for domain model class AccessionProcedure.
 * @see com.cardiodx.db.waban.table.AccessionProcedure
 * @author Hibernate Tools
 */
public class AccessionProcedureHome {

	private static final Log log = LogFactory
			.getLog(AccessionProcedureHome.class);

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

	public void persist(AccessionProcedure transientInstance) {
		log.debug("persisting AccessionProcedure instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AccessionProcedure instance) {
		log.debug("attaching dirty AccessionProcedure instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccessionProcedure instance) {
		log.debug("attaching clean AccessionProcedure instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AccessionProcedure persistentInstance) {
		log.debug("deleting AccessionProcedure instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccessionProcedure merge(AccessionProcedure detachedInstance) {
		log.debug("merging AccessionProcedure instance");
		try {
			AccessionProcedure result = (AccessionProcedure) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AccessionProcedure findById(java.math.BigDecimal id) {
		log.debug("getting AccessionProcedure instance with id: " + id);
		try {
			AccessionProcedure instance = (AccessionProcedure) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AccessionProcedure",
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

	public List<AccessionProcedure> findByExample(AccessionProcedure instance) {
		log.debug("finding AccessionProcedure instance by example");
		try {
			List<AccessionProcedure> results = (List<AccessionProcedure>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AccessionProcedure")
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
