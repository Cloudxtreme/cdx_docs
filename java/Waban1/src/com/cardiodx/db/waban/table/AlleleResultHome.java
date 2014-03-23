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
 * Home object for domain model class AlleleResult.
 * @see com.cardiodx.db.waban.table.AlleleResult
 * @author Hibernate Tools
 */
public class AlleleResultHome {

	private static final Log log = LogFactory.getLog(AlleleResultHome.class);

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

	public void persist(AlleleResult transientInstance) {
		log.debug("persisting AlleleResult instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AlleleResult instance) {
		log.debug("attaching dirty AlleleResult instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlleleResult instance) {
		log.debug("attaching clean AlleleResult instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AlleleResult persistentInstance) {
		log.debug("deleting AlleleResult instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlleleResult merge(AlleleResult detachedInstance) {
		log.debug("merging AlleleResult instance");
		try {
			AlleleResult result = (AlleleResult) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AlleleResult findById(java.math.BigDecimal id) {
		log.debug("getting AlleleResult instance with id: " + id);
		try {
			AlleleResult instance = (AlleleResult) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AlleleResult", id);
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

	public List<AlleleResult> findByExample(AlleleResult instance) {
		log.debug("finding AlleleResult instance by example");
		try {
			List<AlleleResult> results = (List<AlleleResult>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AlleleResult")
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
