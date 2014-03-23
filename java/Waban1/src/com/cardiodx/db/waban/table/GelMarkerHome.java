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
 * Home object for domain model class GelMarker.
 * @see com.cardiodx.db.waban.table.GelMarker
 * @author Hibernate Tools
 */
public class GelMarkerHome {

	private static final Log log = LogFactory.getLog(GelMarkerHome.class);

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

	public void persist(GelMarker transientInstance) {
		log.debug("persisting GelMarker instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GelMarker instance) {
		log.debug("attaching dirty GelMarker instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GelMarker instance) {
		log.debug("attaching clean GelMarker instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GelMarker persistentInstance) {
		log.debug("deleting GelMarker instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GelMarker merge(GelMarker detachedInstance) {
		log.debug("merging GelMarker instance");
		try {
			GelMarker result = (GelMarker) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GelMarker findById(com.cardiodx.db.waban.table.GelMarkerId id) {
		log.debug("getting GelMarker instance with id: " + id);
		try {
			GelMarker instance = (GelMarker) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GelMarker", id);
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

	public List<GelMarker> findByExample(GelMarker instance) {
		log.debug("finding GelMarker instance by example");
		try {
			List<GelMarker> results = (List<GelMarker>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.GelMarker")
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
