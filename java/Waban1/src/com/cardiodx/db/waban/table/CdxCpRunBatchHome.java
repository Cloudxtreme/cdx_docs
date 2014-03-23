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
 * Home object for domain model class CdxCpRunBatch.
 * @see com.cardiodx.db.waban.table.CdxCpRunBatch
 * @author Hibernate Tools
 */
public class CdxCpRunBatchHome {

	private static final Log log = LogFactory.getLog(CdxCpRunBatchHome.class);

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

	public void persist(CdxCpRunBatch transientInstance) {
		log.debug("persisting CdxCpRunBatch instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CdxCpRunBatch instance) {
		log.debug("attaching dirty CdxCpRunBatch instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CdxCpRunBatch instance) {
		log.debug("attaching clean CdxCpRunBatch instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CdxCpRunBatch persistentInstance) {
		log.debug("deleting CdxCpRunBatch instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CdxCpRunBatch merge(CdxCpRunBatch detachedInstance) {
		log.debug("merging CdxCpRunBatch instance");
		try {
			CdxCpRunBatch result = (CdxCpRunBatch) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CdxCpRunBatch findById(java.math.BigDecimal id) {
		log.debug("getting CdxCpRunBatch instance with id: " + id);
		try {
			CdxCpRunBatch instance = (CdxCpRunBatch) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.CdxCpRunBatch", id);
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

	public List<CdxCpRunBatch> findByExample(CdxCpRunBatch instance) {
		log.debug("finding CdxCpRunBatch instance by example");
		try {
			List<CdxCpRunBatch> results = (List<CdxCpRunBatch>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.CdxCpRunBatch")
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
