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
 * Home object for domain model class ZipcodesR.
 * @see com.cardiodx.db.waban.table.ZipcodesR
 * @author Hibernate Tools
 */
public class ZipcodesRHome {

	private static final Log log = LogFactory.getLog(ZipcodesRHome.class);

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

	public void persist(ZipcodesR transientInstance) {
		log.debug("persisting ZipcodesR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ZipcodesR instance) {
		log.debug("attaching dirty ZipcodesR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ZipcodesR instance) {
		log.debug("attaching clean ZipcodesR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ZipcodesR persistentInstance) {
		log.debug("deleting ZipcodesR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ZipcodesR merge(ZipcodesR detachedInstance) {
		log.debug("merging ZipcodesR instance");
		try {
			ZipcodesR result = (ZipcodesR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ZipcodesR findById(com.cardiodx.db.waban.table.ZipcodesRId id) {
		log.debug("getting ZipcodesR instance with id: " + id);
		try {
			ZipcodesR instance = (ZipcodesR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ZipcodesR", id);
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

	public List<ZipcodesR> findByExample(ZipcodesR instance) {
		log.debug("finding ZipcodesR instance by example");
		try {
			List<ZipcodesR> results = (List<ZipcodesR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ZipcodesR")
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
