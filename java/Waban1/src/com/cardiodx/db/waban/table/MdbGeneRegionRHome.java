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
 * Home object for domain model class MdbGeneRegionR.
 * @see com.cardiodx.db.waban.table.MdbGeneRegionR
 * @author Hibernate Tools
 */
public class MdbGeneRegionRHome {

	private static final Log log = LogFactory.getLog(MdbGeneRegionRHome.class);

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

	public void persist(MdbGeneRegionR transientInstance) {
		log.debug("persisting MdbGeneRegionR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbGeneRegionR instance) {
		log.debug("attaching dirty MdbGeneRegionR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbGeneRegionR instance) {
		log.debug("attaching clean MdbGeneRegionR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbGeneRegionR persistentInstance) {
		log.debug("deleting MdbGeneRegionR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbGeneRegionR merge(MdbGeneRegionR detachedInstance) {
		log.debug("merging MdbGeneRegionR instance");
		try {
			MdbGeneRegionR result = (MdbGeneRegionR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbGeneRegionR findById(
			com.cardiodx.db.waban.table.MdbGeneRegionRId id) {
		log.debug("getting MdbGeneRegionR instance with id: " + id);
		try {
			MdbGeneRegionR instance = (MdbGeneRegionR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbGeneRegionR", id);
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

	public List<MdbGeneRegionR> findByExample(MdbGeneRegionR instance) {
		log.debug("finding MdbGeneRegionR instance by example");
		try {
			List<MdbGeneRegionR> results = (List<MdbGeneRegionR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbGeneRegionR")
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
