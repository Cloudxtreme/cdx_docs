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
 * Home object for domain model class FreezerR.
 * @see com.cardiodx.db.waban.table.FreezerR
 * @author Hibernate Tools
 */
public class FreezerRHome {

	private static final Log log = LogFactory.getLog(FreezerRHome.class);

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

	public void persist(FreezerR transientInstance) {
		log.debug("persisting FreezerR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FreezerR instance) {
		log.debug("attaching dirty FreezerR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FreezerR instance) {
		log.debug("attaching clean FreezerR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FreezerR persistentInstance) {
		log.debug("deleting FreezerR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FreezerR merge(FreezerR detachedInstance) {
		log.debug("merging FreezerR instance");
		try {
			FreezerR result = (FreezerR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FreezerR findById(com.cardiodx.db.waban.table.FreezerRId id) {
		log.debug("getting FreezerR instance with id: " + id);
		try {
			FreezerR instance = (FreezerR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.FreezerR", id);
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

	public List<FreezerR> findByExample(FreezerR instance) {
		log.debug("finding FreezerR instance by example");
		try {
			List<FreezerR> results = (List<FreezerR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.FreezerR")
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
