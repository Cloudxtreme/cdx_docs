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
 * Home object for domain model class ChangeReasonR.
 * @see com.cardiodx.db.waban.table.ChangeReasonR
 * @author Hibernate Tools
 */
public class ChangeReasonRHome {

	private static final Log log = LogFactory.getLog(ChangeReasonRHome.class);

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

	public void persist(ChangeReasonR transientInstance) {
		log.debug("persisting ChangeReasonR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChangeReasonR instance) {
		log.debug("attaching dirty ChangeReasonR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChangeReasonR instance) {
		log.debug("attaching clean ChangeReasonR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChangeReasonR persistentInstance) {
		log.debug("deleting ChangeReasonR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChangeReasonR merge(ChangeReasonR detachedInstance) {
		log.debug("merging ChangeReasonR instance");
		try {
			ChangeReasonR result = (ChangeReasonR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChangeReasonR findById(com.cardiodx.db.waban.table.ChangeReasonRId id) {
		log.debug("getting ChangeReasonR instance with id: " + id);
		try {
			ChangeReasonR instance = (ChangeReasonR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ChangeReasonR", id);
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

	public List<ChangeReasonR> findByExample(ChangeReasonR instance) {
		log.debug("finding ChangeReasonR instance by example");
		try {
			List<ChangeReasonR> results = (List<ChangeReasonR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ChangeReasonR")
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
