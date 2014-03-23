package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MdbCoveredRois.
 * @see com.cardiodx.db.waban.view.MdbCoveredRois
 * @author Hibernate Tools
 */
public class MdbCoveredRoisHome {

	private static final Log log = LogFactory.getLog(MdbCoveredRoisHome.class);

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

	public void persist(MdbCoveredRois transientInstance) {
		log.debug("persisting MdbCoveredRois instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbCoveredRois instance) {
		log.debug("attaching dirty MdbCoveredRois instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbCoveredRois instance) {
		log.debug("attaching clean MdbCoveredRois instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbCoveredRois persistentInstance) {
		log.debug("deleting MdbCoveredRois instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbCoveredRois merge(MdbCoveredRois detachedInstance) {
		log.debug("merging MdbCoveredRois instance");
		try {
			MdbCoveredRois result = (MdbCoveredRois) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbCoveredRois findById(
			com.cardiodx.db.waban.view.MdbCoveredRoisId id) {
		log.debug("getting MdbCoveredRois instance with id: " + id);
		try {
			MdbCoveredRois instance = (MdbCoveredRois) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.MdbCoveredRois", id);
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

	public List<MdbCoveredRois> findByExample(MdbCoveredRois instance) {
		log.debug("finding MdbCoveredRois instance by example");
		try {
			List<MdbCoveredRois> results = (List<MdbCoveredRois>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.MdbCoveredRois")
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
