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
 * Home object for domain model class MdbLiterature.
 * @see com.cardiodx.db.waban.table.MdbLiterature
 * @author Hibernate Tools
 */
public class MdbLiteratureHome {

	private static final Log log = LogFactory.getLog(MdbLiteratureHome.class);

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

	public void persist(MdbLiterature transientInstance) {
		log.debug("persisting MdbLiterature instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbLiterature instance) {
		log.debug("attaching dirty MdbLiterature instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbLiterature instance) {
		log.debug("attaching clean MdbLiterature instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbLiterature persistentInstance) {
		log.debug("deleting MdbLiterature instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbLiterature merge(MdbLiterature detachedInstance) {
		log.debug("merging MdbLiterature instance");
		try {
			MdbLiterature result = (MdbLiterature) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbLiterature findById(java.math.BigDecimal id) {
		log.debug("getting MdbLiterature instance with id: " + id);
		try {
			MdbLiterature instance = (MdbLiterature) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbLiterature", id);
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

	public List<MdbLiterature> findByExample(MdbLiterature instance) {
		log.debug("finding MdbLiterature instance by example");
		try {
			List<MdbLiterature> results = (List<MdbLiterature>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MdbLiterature")
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
