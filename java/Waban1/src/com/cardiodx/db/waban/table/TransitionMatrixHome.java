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
 * Home object for domain model class TransitionMatrix.
 * @see com.cardiodx.db.waban.table.TransitionMatrix
 * @author Hibernate Tools
 */
public class TransitionMatrixHome {

	private static final Log log = LogFactory
			.getLog(TransitionMatrixHome.class);

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

	public void persist(TransitionMatrix transientInstance) {
		log.debug("persisting TransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TransitionMatrix instance) {
		log.debug("attaching dirty TransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TransitionMatrix instance) {
		log.debug("attaching clean TransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TransitionMatrix persistentInstance) {
		log.debug("deleting TransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TransitionMatrix merge(TransitionMatrix detachedInstance) {
		log.debug("merging TransitionMatrix instance");
		try {
			TransitionMatrix result = (TransitionMatrix) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TransitionMatrix findById(java.math.BigDecimal id) {
		log.debug("getting TransitionMatrix instance with id: " + id);
		try {
			TransitionMatrix instance = (TransitionMatrix) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TransitionMatrix", id);
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

	public List<TransitionMatrix> findByExample(TransitionMatrix instance) {
		log.debug("finding TransitionMatrix instance by example");
		try {
			List<TransitionMatrix> results = (List<TransitionMatrix>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TransitionMatrix")
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
