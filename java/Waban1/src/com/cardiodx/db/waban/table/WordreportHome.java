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
 * Home object for domain model class Wordreport.
 * @see com.cardiodx.db.waban.table.Wordreport
 * @author Hibernate Tools
 */
public class WordreportHome {

	private static final Log log = LogFactory.getLog(WordreportHome.class);

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

	public void persist(Wordreport transientInstance) {
		log.debug("persisting Wordreport instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Wordreport instance) {
		log.debug("attaching dirty Wordreport instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Wordreport instance) {
		log.debug("attaching clean Wordreport instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Wordreport persistentInstance) {
		log.debug("deleting Wordreport instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Wordreport merge(Wordreport detachedInstance) {
		log.debug("merging Wordreport instance");
		try {
			Wordreport result = (Wordreport) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Wordreport findById(java.math.BigDecimal id) {
		log.debug("getting Wordreport instance with id: " + id);
		try {
			Wordreport instance = (Wordreport) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.Wordreport", id);
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

	public List<Wordreport> findByExample(Wordreport instance) {
		log.debug("finding Wordreport instance by example");
		try {
			List<Wordreport> results = (List<Wordreport>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.Wordreport")
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
