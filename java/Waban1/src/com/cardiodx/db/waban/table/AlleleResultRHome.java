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
 * Home object for domain model class AlleleResultR.
 * @see com.cardiodx.db.waban.table.AlleleResultR
 * @author Hibernate Tools
 */
public class AlleleResultRHome {

	private static final Log log = LogFactory.getLog(AlleleResultRHome.class);

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

	public void persist(AlleleResultR transientInstance) {
		log.debug("persisting AlleleResultR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AlleleResultR instance) {
		log.debug("attaching dirty AlleleResultR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlleleResultR instance) {
		log.debug("attaching clean AlleleResultR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AlleleResultR persistentInstance) {
		log.debug("deleting AlleleResultR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlleleResultR merge(AlleleResultR detachedInstance) {
		log.debug("merging AlleleResultR instance");
		try {
			AlleleResultR result = (AlleleResultR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AlleleResultR findById(com.cardiodx.db.waban.table.AlleleResultRId id) {
		log.debug("getting AlleleResultR instance with id: " + id);
		try {
			AlleleResultR instance = (AlleleResultR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AlleleResultR", id);
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

	public List<AlleleResultR> findByExample(AlleleResultR instance) {
		log.debug("finding AlleleResultR instance by example");
		try {
			List<AlleleResultR> results = (List<AlleleResultR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AlleleResultR")
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
