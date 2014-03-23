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
 * Home object for domain model class ChangeTable.
 * @see com.cardiodx.db.waban.table.ChangeTable
 * @author Hibernate Tools
 */
public class ChangeTableHome {

	private static final Log log = LogFactory.getLog(ChangeTableHome.class);

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

	public void persist(ChangeTable transientInstance) {
		log.debug("persisting ChangeTable instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChangeTable instance) {
		log.debug("attaching dirty ChangeTable instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChangeTable instance) {
		log.debug("attaching clean ChangeTable instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChangeTable persistentInstance) {
		log.debug("deleting ChangeTable instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChangeTable merge(ChangeTable detachedInstance) {
		log.debug("merging ChangeTable instance");
		try {
			ChangeTable result = (ChangeTable) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChangeTable findById(java.lang.String id) {
		log.debug("getting ChangeTable instance with id: " + id);
		try {
			ChangeTable instance = (ChangeTable) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ChangeTable", id);
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

	public List<ChangeTable> findByExample(ChangeTable instance) {
		log.debug("finding ChangeTable instance by example");
		try {
			List<ChangeTable> results = (List<ChangeTable>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ChangeTable")
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