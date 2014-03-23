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
 * Home object for domain model class WordreportR.
 * @see com.cardiodx.db.waban.table.WordreportR
 * @author Hibernate Tools
 */
public class WordreportRHome {

	private static final Log log = LogFactory.getLog(WordreportRHome.class);

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

	public void persist(WordreportR transientInstance) {
		log.debug("persisting WordreportR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WordreportR instance) {
		log.debug("attaching dirty WordreportR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WordreportR instance) {
		log.debug("attaching clean WordreportR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WordreportR persistentInstance) {
		log.debug("deleting WordreportR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WordreportR merge(WordreportR detachedInstance) {
		log.debug("merging WordreportR instance");
		try {
			WordreportR result = (WordreportR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WordreportR findById(com.cardiodx.db.waban.table.WordreportRId id) {
		log.debug("getting WordreportR instance with id: " + id);
		try {
			WordreportR instance = (WordreportR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WordreportR", id);
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

	public List<WordreportR> findByExample(WordreportR instance) {
		log.debug("finding WordreportR instance by example");
		try {
			List<WordreportR> results = (List<WordreportR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.WordreportR")
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
