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
 * Home object for domain model class GeneResultR.
 * @see com.cardiodx.db.waban.table.GeneResultR
 * @author Hibernate Tools
 */
public class GeneResultRHome {

	private static final Log log = LogFactory.getLog(GeneResultRHome.class);

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

	public void persist(GeneResultR transientInstance) {
		log.debug("persisting GeneResultR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GeneResultR instance) {
		log.debug("attaching dirty GeneResultR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GeneResultR instance) {
		log.debug("attaching clean GeneResultR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GeneResultR persistentInstance) {
		log.debug("deleting GeneResultR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GeneResultR merge(GeneResultR detachedInstance) {
		log.debug("merging GeneResultR instance");
		try {
			GeneResultR result = (GeneResultR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GeneResultR findById(com.cardiodx.db.waban.table.GeneResultRId id) {
		log.debug("getting GeneResultR instance with id: " + id);
		try {
			GeneResultR instance = (GeneResultR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.GeneResultR", id);
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

	public List<GeneResultR> findByExample(GeneResultR instance) {
		log.debug("finding GeneResultR instance by example");
		try {
			List<GeneResultR> results = (List<GeneResultR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.GeneResultR")
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
