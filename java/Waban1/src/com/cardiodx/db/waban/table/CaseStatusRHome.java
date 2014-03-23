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
 * Home object for domain model class CaseStatusR.
 * @see com.cardiodx.db.waban.table.CaseStatusR
 * @author Hibernate Tools
 */
public class CaseStatusRHome {

	private static final Log log = LogFactory.getLog(CaseStatusRHome.class);

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

	public void persist(CaseStatusR transientInstance) {
		log.debug("persisting CaseStatusR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CaseStatusR instance) {
		log.debug("attaching dirty CaseStatusR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CaseStatusR instance) {
		log.debug("attaching clean CaseStatusR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CaseStatusR persistentInstance) {
		log.debug("deleting CaseStatusR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CaseStatusR merge(CaseStatusR detachedInstance) {
		log.debug("merging CaseStatusR instance");
		try {
			CaseStatusR result = (CaseStatusR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CaseStatusR findById(com.cardiodx.db.waban.table.CaseStatusRId id) {
		log.debug("getting CaseStatusR instance with id: " + id);
		try {
			CaseStatusR instance = (CaseStatusR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.CaseStatusR", id);
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

	public List<CaseStatusR> findByExample(CaseStatusR instance) {
		log.debug("finding CaseStatusR instance by example");
		try {
			List<CaseStatusR> results = (List<CaseStatusR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.CaseStatusR")
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
