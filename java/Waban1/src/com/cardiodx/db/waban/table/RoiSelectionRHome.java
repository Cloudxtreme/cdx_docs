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
 * Home object for domain model class RoiSelectionR.
 * @see com.cardiodx.db.waban.table.RoiSelectionR
 * @author Hibernate Tools
 */
public class RoiSelectionRHome {

	private static final Log log = LogFactory.getLog(RoiSelectionRHome.class);

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

	public void persist(RoiSelectionR transientInstance) {
		log.debug("persisting RoiSelectionR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RoiSelectionR instance) {
		log.debug("attaching dirty RoiSelectionR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoiSelectionR instance) {
		log.debug("attaching clean RoiSelectionR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RoiSelectionR persistentInstance) {
		log.debug("deleting RoiSelectionR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoiSelectionR merge(RoiSelectionR detachedInstance) {
		log.debug("merging RoiSelectionR instance");
		try {
			RoiSelectionR result = (RoiSelectionR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoiSelectionR findById(com.cardiodx.db.waban.table.RoiSelectionRId id) {
		log.debug("getting RoiSelectionR instance with id: " + id);
		try {
			RoiSelectionR instance = (RoiSelectionR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.RoiSelectionR", id);
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

	public List<RoiSelectionR> findByExample(RoiSelectionR instance) {
		log.debug("finding RoiSelectionR instance by example");
		try {
			List<RoiSelectionR> results = (List<RoiSelectionR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.RoiSelectionR")
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
