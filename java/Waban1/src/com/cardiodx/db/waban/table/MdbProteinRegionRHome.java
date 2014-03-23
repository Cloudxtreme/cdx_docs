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
 * Home object for domain model class MdbProteinRegionR.
 * @see com.cardiodx.db.waban.table.MdbProteinRegionR
 * @author Hibernate Tools
 */
public class MdbProteinRegionRHome {

	private static final Log log = LogFactory
			.getLog(MdbProteinRegionRHome.class);

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

	public void persist(MdbProteinRegionR transientInstance) {
		log.debug("persisting MdbProteinRegionR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbProteinRegionR instance) {
		log.debug("attaching dirty MdbProteinRegionR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbProteinRegionR instance) {
		log.debug("attaching clean MdbProteinRegionR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbProteinRegionR persistentInstance) {
		log.debug("deleting MdbProteinRegionR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbProteinRegionR merge(MdbProteinRegionR detachedInstance) {
		log.debug("merging MdbProteinRegionR instance");
		try {
			MdbProteinRegionR result = (MdbProteinRegionR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbProteinRegionR findById(
			com.cardiodx.db.waban.table.MdbProteinRegionRId id) {
		log.debug("getting MdbProteinRegionR instance with id: " + id);
		try {
			MdbProteinRegionR instance = (MdbProteinRegionR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.MdbProteinRegionR", id);
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

	public List<MdbProteinRegionR> findByExample(MdbProteinRegionR instance) {
		log.debug("finding MdbProteinRegionR instance by example");
		try {
			List<MdbProteinRegionR> results = (List<MdbProteinRegionR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbProteinRegionR")
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
