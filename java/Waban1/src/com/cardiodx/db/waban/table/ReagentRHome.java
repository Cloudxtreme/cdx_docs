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
 * Home object for domain model class ReagentR.
 * @see com.cardiodx.db.waban.table.ReagentR
 * @author Hibernate Tools
 */
public class ReagentRHome {

	private static final Log log = LogFactory.getLog(ReagentRHome.class);

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

	public void persist(ReagentR transientInstance) {
		log.debug("persisting ReagentR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReagentR instance) {
		log.debug("attaching dirty ReagentR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReagentR instance) {
		log.debug("attaching clean ReagentR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReagentR persistentInstance) {
		log.debug("deleting ReagentR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReagentR merge(ReagentR detachedInstance) {
		log.debug("merging ReagentR instance");
		try {
			ReagentR result = (ReagentR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReagentR findById(com.cardiodx.db.waban.table.ReagentRId id) {
		log.debug("getting ReagentR instance with id: " + id);
		try {
			ReagentR instance = (ReagentR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ReagentR", id);
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

	public List<ReagentR> findByExample(ReagentR instance) {
		log.debug("finding ReagentR instance by example");
		try {
			List<ReagentR> results = (List<ReagentR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ReagentR")
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
