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
 * Home object for domain model class AlleleR.
 * @see com.cardiodx.db.waban.table.AlleleR
 * @author Hibernate Tools
 */
public class AlleleRHome {

	private static final Log log = LogFactory.getLog(AlleleRHome.class);

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

	public void persist(AlleleR transientInstance) {
		log.debug("persisting AlleleR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AlleleR instance) {
		log.debug("attaching dirty AlleleR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlleleR instance) {
		log.debug("attaching clean AlleleR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AlleleR persistentInstance) {
		log.debug("deleting AlleleR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlleleR merge(AlleleR detachedInstance) {
		log.debug("merging AlleleR instance");
		try {
			AlleleR result = (AlleleR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AlleleR findById(com.cardiodx.db.waban.table.AlleleRId id) {
		log.debug("getting AlleleR instance with id: " + id);
		try {
			AlleleR instance = (AlleleR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AlleleR", id);
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

	public List<AlleleR> findByExample(AlleleR instance) {
		log.debug("finding AlleleR instance by example");
		try {
			List<AlleleR> results = (List<AlleleR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AlleleR")
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
