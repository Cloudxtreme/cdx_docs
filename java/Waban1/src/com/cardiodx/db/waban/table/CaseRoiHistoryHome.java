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
 * Home object for domain model class CaseRoiHistory.
 * @see com.cardiodx.db.waban.table.CaseRoiHistory
 * @author Hibernate Tools
 */
public class CaseRoiHistoryHome {

	private static final Log log = LogFactory.getLog(CaseRoiHistoryHome.class);

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

	public void persist(CaseRoiHistory transientInstance) {
		log.debug("persisting CaseRoiHistory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CaseRoiHistory instance) {
		log.debug("attaching dirty CaseRoiHistory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CaseRoiHistory instance) {
		log.debug("attaching clean CaseRoiHistory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CaseRoiHistory persistentInstance) {
		log.debug("deleting CaseRoiHistory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CaseRoiHistory merge(CaseRoiHistory detachedInstance) {
		log.debug("merging CaseRoiHistory instance");
		try {
			CaseRoiHistory result = (CaseRoiHistory) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CaseRoiHistory findById(java.math.BigDecimal id) {
		log.debug("getting CaseRoiHistory instance with id: " + id);
		try {
			CaseRoiHistory instance = (CaseRoiHistory) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.CaseRoiHistory", id);
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

	public List<CaseRoiHistory> findByExample(CaseRoiHistory instance) {
		log.debug("finding CaseRoiHistory instance by example");
		try {
			List<CaseRoiHistory> results = (List<CaseRoiHistory>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.CaseRoiHistory")
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
