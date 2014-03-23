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
 * Home object for domain model class PendingSampleTableR.
 * @see com.cardiodx.db.waban.table.PendingSampleTableR
 * @author Hibernate Tools
 */
public class PendingSampleTableRHome {

	private static final Log log = LogFactory
			.getLog(PendingSampleTableRHome.class);

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

	public void persist(PendingSampleTableR transientInstance) {
		log.debug("persisting PendingSampleTableR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingSampleTableR instance) {
		log.debug("attaching dirty PendingSampleTableR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingSampleTableR instance) {
		log.debug("attaching clean PendingSampleTableR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingSampleTableR persistentInstance) {
		log.debug("deleting PendingSampleTableR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingSampleTableR merge(PendingSampleTableR detachedInstance) {
		log.debug("merging PendingSampleTableR instance");
		try {
			PendingSampleTableR result = (PendingSampleTableR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingSampleTableR findById(
			com.cardiodx.db.waban.table.PendingSampleTableRId id) {
		log.debug("getting PendingSampleTableR instance with id: " + id);
		try {
			PendingSampleTableR instance = (PendingSampleTableR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PendingSampleTableR",
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

	public List<PendingSampleTableR> findByExample(PendingSampleTableR instance) {
		log.debug("finding PendingSampleTableR instance by example");
		try {
			List<PendingSampleTableR> results = (List<PendingSampleTableR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PendingSampleTableR")
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
